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
public class ChineseWord {

    @Column(name = "sinogramme")
    private String sinogramme;

    @Column(name = "pinyin")
    private String pinyin;

    @Override
    public String toString() {
        return "AdditionalForms{" +
                "kanji='" + sinogramme + '\'' +
                ", hiragana='" + pinyin + '\'' +
                '}';
    }
}