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
public class GreekWord {

    @Column(name = "greek")
    private String greek;

    @Column(name = "romanisationGreek")
    private String romanisationGreek;

    @Override
    public String toString() {
        return "AdditionalForms{" +
                "kanji='" + greek + '\'' +
                ", hiragana='" + romanisationGreek + '\'' +
                '}';
    }

}
