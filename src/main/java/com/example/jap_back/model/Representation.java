package com.example.jap_back.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Representation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private ChineseWord chineseWord;
    @Embedded
    private JapaneseWord japaneseWord;
    private String hangeul;
    private String arabic; // Arabe
    private String latin; // Toutes les langues ayant un alphabet latin
    private String cyrillic; // Alphabet cyrillique
    private String devanagari; // Hindi et sanskrit
    private String greek; // Grec
    private String thai; // Thaï
    private String georgian; // Géorgien
    private String armenian; // Arménien
    @OneToOne
    @JoinColumn(name = "word_id")
    private Word word;

    // Constructors, getters, and setters
    @Override
    public String toString() {
        return "Representation{" +
                "id=" + id +
                ", chineseWord=" + (chineseWord != null ? chineseWord.toString() : "null") +
                ", hangeul='" + hangeul + '\'' +
                ", arabic='" + arabic + '\'' +
                ", latin='" + latin + '\'' +
                ", cyrillic='" + cyrillic + '\'' +
                ", devanagari='" + devanagari + '\'' +
                ", greek='" + greek + '\'' +
                ", thai='" + thai + '\'' +
                ", georgian='" + georgian + '\'' +
                ", armenian='" + armenian + '\'' +
                ", word=" + (word != null ? word.getTranslation() : "null") +
                '}';
    }
}