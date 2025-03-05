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
public class GeorgianWord {

    @Column(name = "georgian")
    private String georgian;

    @Column(name = "romanisationGeorgian")
    private String romanisationGeorgian;

    @Override
    public String toString() {
        return "AdditionalForms{" +
                "kanji='" + georgian + '\'' +
                ", hiragana='" + romanisationGeorgian + '\'' +
                '}';
    }

}
