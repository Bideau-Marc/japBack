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
public class KoreanWord {

    @Column(name = "hangeul")
    private String hangeul;

    @Column(name = "romaja")
    private String romaja;

    @Override
    public String toString() {
        return "AdditionalForms{" +
                "kanji='" + hangeul + '\'' +
                ", hiragana='" + romaja + '\'' +
                '}';
    }

}
