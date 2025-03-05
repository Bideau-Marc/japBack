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
public class ArmenianWord {

    @Column(name = "armenian")
    private String armenian;

    @Column(name = "romanisationArmenian")
    private String romanisationArmenian;

    @Override
    public String toString() {
        return "AdditionalForms{" +
                "kanji='" + armenian + '\'' +
                ", hiragana='" + romanisationArmenian + '\'' +
                '}';
    }

}
