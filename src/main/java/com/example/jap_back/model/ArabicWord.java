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
public class ArabicWord {

    @Column(name = "arabic")
    private String arabic;

    @Column(name = "Arabizi")
    private String Arabizi;

    @Override
    public String toString() {
        return "AdditionalForms{" +
                "kanji='" + arabic + '\'' +
                ", hiragana='" + Arabizi + '\'' +
                '}';
    }

}
