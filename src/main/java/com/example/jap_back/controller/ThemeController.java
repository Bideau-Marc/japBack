package com.example.jap_back.controller;

import com.example.jap_back.model.Theme;
import com.example.jap_back.service.ThemeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/themes")
public class ThemeController {

    @Autowired
    private ThemeService themeService;

    // Create a new theme
    @PostMapping
    public ResponseEntity<Theme> createTheme(@RequestBody Theme theme) {
        Theme createdTheme = themeService.createTheme(theme);
        return ResponseEntity.ok(createdTheme);
    }

    // Get a theme by ID
    @GetMapping("/{id}")
    public ResponseEntity<Theme> getThemeById(@PathVariable Long id) {
        Theme theme = themeService.getThemeById(id);
        return theme != null ? ResponseEntity.ok(theme) : ResponseEntity.notFound().build();
    }

    // Get all themes
    @GetMapping
    public ResponseEntity<List<Theme>> getAllThemes() {
        List<Theme> themes = themeService.getAllThemes();
        return ResponseEntity.ok(themes);
    }

    // Update an existing theme
    @PutMapping("/{id}")
    public ResponseEntity<Theme> updateTheme(@PathVariable Long id, @RequestBody Theme theme) {
        theme.setId(id);
        Theme updatedTheme = themeService.updateTheme(theme);
        return ResponseEntity.ok(updatedTheme);
    }

    // Delete a theme
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTheme(@PathVariable Long id) {
        Theme theme = themeService.getThemeById(id);
        if (theme != null) {
            themeService.deleteTheme(theme);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
