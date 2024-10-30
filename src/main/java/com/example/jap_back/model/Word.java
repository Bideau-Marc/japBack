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
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String translation;
    private String exemple;
    @ManyToOne
    @JoinColumn(name = "theme_id")
    private Theme theme;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "representation_id")
    private Representation representation;

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", translation='" + translation + '\'' +
                ", exemple='" + exemple + '\'' +
                ", theme=" + (theme != null ? theme.getName() : "null") +
                ", representation=" + (representation != null ? representation.toString() : "null") +
                '}';
    }

}