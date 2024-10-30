package com.example.jap_back.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JapaneseWord {

    @Column(name = "kanji")
    private String kanji;

    @Column(name = "hiragana")
    private String hiragana;

    @Column(name = "katakana")
    private String katakana;

    @Column(name = "Romaji")
    private String romaji;
    // Getters and setters
    // ...

    @Override
    public String toString() {
        return "AdditionalForms{" +
                "kanji='" + kanji + '\'' +
                ", hiragana='" + hiragana + '\'' +
                ", katakana='" + katakana + '\'' +
                ", katakana='" + romaji + '\'' +
                '}';
    }
}