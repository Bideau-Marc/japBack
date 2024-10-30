package com.example.jap_back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.example.jap_back.model.Theme;
import com.example.jap_back.repository.ThemeRepository;

@Service
public class ThemeService {

    @Autowired
    private ThemeRepository themeRepository;

    public Theme createTheme(Theme theme) {
        return themeRepository.save(theme);

    }

    public Theme getThemeById(Long id) {
        return themeRepository.findById(id).orElseThrow(() -> new RuntimeException("Theme not found"));
    }

    public Theme updateTheme(Theme theme) {
        return themeRepository.save(theme);
    }

    public void deleteTheme(Theme theme) {
        themeRepository.delete(theme);
    }

    public List<Theme> getAllThemes() {
        return themeRepository.findAll();
    }

    public Theme getThemeByNameAndLanguage(String name, String language) {
        return themeRepository.findByNameAndLanguage(name, language);
    }

}
