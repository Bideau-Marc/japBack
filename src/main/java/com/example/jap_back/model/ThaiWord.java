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
public class ThaiWord {

    @Column(name = "thai")
    private String thai;

    @Column(name = "romanisationThai")
    private String romanisationThai;

    @Override
    public String toString() {
        return "AdditionalForms{" +
                "kanji='" + thai + '\'' +
                ", hiragana='" + romanisationThai + '\'' +
                '}';
    }

}
