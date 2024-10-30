package com.example.jap_back.controller;

import java.util.ArrayList;

import com.example.jap_back.model.Theme;
import com.example.jap_back.model.Word;
import com.example.jap_back.service.ThemeService;
import com.example.jap_back.service.WordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/words")
public class WordController {

    @Autowired
    private WordService wordService;

    // Create a new word
    @PostMapping
    public ResponseEntity<Word> createWord(@RequestBody Word word) {
        Word createdWord = wordService.createWord(word);
        return ResponseEntity.ok(createdWord);
    }

    // Get a word by ID
    @GetMapping("/{id}")
    public ResponseEntity<Word> getWordById(@PathVariable Long id) {
        Word word = wordService.getWordById(id);
        return word != null ? ResponseEntity.ok(word) : ResponseEntity.notFound().build();
    }

    // Get all words
    @GetMapping
    public ResponseEntity<List<Word>> getAllWords() {
        List<Word> words = wordService.getWords();
        return ResponseEntity.ok(words);
    }

    // Update an existing word
    @PutMapping("/{id}")
    public ResponseEntity<Word> updateWord(@PathVariable Long id, @RequestBody Word word) {
        word.setId(id);
        Word updatedWord = wordService.updateWord(word);
        return ResponseEntity.ok(updatedWord);
    }

    // Delete a word
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWord(@PathVariable Long id) {
        Word word = wordService.getWordById(id);
        if (word != null) {
            wordService.deleteWord(word);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Find words by theme and language
    @Autowired
    private ThemeService themeService;

    @GetMapping("/search")
    public ResponseEntity<List<Word>> findWordsByThemeAndLanguage(
            @RequestParam String theme,
            @RequestParam String language) {
        System.out.println("Received theme: " + theme);
        System.out.println("Received language: " + language);
        Theme themeObj = themeService.getThemeByNameAndLanguage(theme, language);
        System.out.println(themeObj.toString());
        List<Word> words = wordService.findWordsByThemeAndLanguage(themeObj);
        return ResponseEntity.ok(words);
    }

    @PostMapping("/multiples")
    public ResponseEntity<List<Word>> createWords(@RequestBody List<Word> words) {
        List<Word> createdWords = new ArrayList<>();

        for (Word word : words) {
            Word createdWord = wordService.createWord(word);
            createdWords.add(createdWord);
        }

        return ResponseEntity.ok(createdWords);
    }

}
