package com.example.jap_back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.jap_back.model.Representation;
import com.example.jap_back.model.Theme;
import com.example.jap_back.model.Word;
import com.example.jap_back.repository.RepresentationRepository;
import com.example.jap_back.repository.ThemeRepository;
import com.example.jap_back.repository.WordRepository;

@Service
public class WordService {
    @Autowired
    private WordRepository wordRepository;

    @Autowired
    private ThemeRepository themeRepository;

    @Autowired
    private RepresentationRepository representationRepository;

    public Word createWord(Word word) {
        if (word.getTheme() != null) {
            Theme theme = themeRepository.findByNameAndLanguage(word.getTheme().getName(),
                    word.getTheme().getLanguage());
            if (theme == null) {
                theme = themeRepository.save(word.getTheme()); // Crée et sauvegarde le nouveau Theme
            }
            word.setTheme(theme);
        }
        System.out.println(word.toString() + "" + word.getRepresentation());
        // Vérifier et créer la representation si nécessaire
        if (word.getRepresentation() != null) {
            // Ajoute un log pour vérifier les métadonnées avant la sauvegarde
            System.out.println("Metadata avant sauvegarde : " + word.getRepresentation());

            // Si Metadata n'a pas d'ID, il doit être considéré comme nouveau
            if (word.getRepresentation().getId() == null) {
                word.setRepresentation(representationRepository.save(word.getRepresentation())); // Crée et
                // sauvegarde la nouvelle representation
                System.out.println("Metadata sauvegardé : " + word.getRepresentation());
            } else {
                Representation existingMetadata = representationRepository.findById(word.getRepresentation().getId())
                        .orElse(null);
                if (existingMetadata == null) {
                    word.setRepresentation(representationRepository.save(word.getRepresentation())); // Crée et
                                                                                                     // sauvegarde la
                    // nouvelle
                    // representation
                    System.out.println("Metadata sauvegardé (nouveau) : " + word.getRepresentation());
                } else {
                    word.setRepresentation(existingMetadata);
                    System.out.println("Metadata existant utilisé : " + existingMetadata);
                }
            }
        }

        // Enregistrer le mot
        return wordRepository.save(word);
    }

    public Word getWordById(Long id) {
        return wordRepository.findById(id).orElseThrow(() -> new RuntimeException("Word not found"));
    }

    public List<Word> getWords() {
        return wordRepository.findAll();
    }

    public Word updateWord(Word word) {
        return wordRepository.save(word);
    }

    public void deleteWord(Word word) {
        wordRepository.delete(word);
    }

    public List<Word> findWordsByThemeAndLanguage(Theme theme) {
        return wordRepository.findByThemeId(theme.getId());
    }
}