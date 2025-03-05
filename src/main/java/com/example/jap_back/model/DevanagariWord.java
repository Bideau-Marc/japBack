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
public class DevanagariWord {

    @Column(name = "devanagari")
    private String devanagari;

    @Column(name = "RomanisationDevanagari")
    private String RomanisationDevanagari;

    @Override
    public String toString() {
        return "AdditionalForms{" +
                "kanji='" + devanagari + '\'' +
                ", hiragana='" + RomanisationDevanagari
                + '\'' +
                '}';
    }

}