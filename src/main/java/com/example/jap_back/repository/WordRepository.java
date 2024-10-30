package com.example.jap_back.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jap_back.model.Word;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {

    List<Word> findByThemeId(Long id);

}