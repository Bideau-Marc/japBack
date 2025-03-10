package com.example.jap_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jap_back.model.Theme;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, Long> {

    Theme findByNameAndLanguage(String name, String language);
}
