package com.example.jap_back.model;

import io.micrometer.common.lang.Nullable;
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

    @Nullable
    @Embedded
    private ChineseWord chineseWord;

    @Nullable
    @Embedded
    private JapaneseWord japaneseWord;

    @Nullable
    @Embedded
    private KoreanWord koreanWord;

    @Nullable
    @Embedded
    private ArabicWord arabicWord; // Arabe

    @Nullable
    private String latin; // Toutes les langues ayant un alphabet latin

    @Nullable
    @Embedded
    private CyrillicWord cyrillicWord; // Alphabet cyrillique

    @Nullable
    @Embedded
    private DevanagariWord devanagariWord; // Hindi et sanskrit

    @Nullable
    @Embedded
    private GreekWord greekWord; // Grec

    @Nullable
    @Embedded
    private ThaiWord thaiWord; // Thaï

    @Nullable
    @Embedded
    private GeorgianWord georgianWord; // Géorgien

    @Nullable
    @Embedded
    private ArmenianWord armenianWord; // Arménien

    @OneToOne
    @JoinColumn(name = "word_id")
    @Nullable
    private Word word; // La relation avec Word peut être null

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Representation{")
                .append("id=").append(id)
                .append(", chineseWord=").append(chineseWord != null ? chineseWord.toString() : "null")
                .append(", japaneseWord=").append(japaneseWord != null ? japaneseWord.toString() : "null")
                .append(", koreanWord=").append(koreanWord != null ? koreanWord.toString() : "null")
                .append(", arabicWord=").append(arabicWord != null ? arabicWord.toString() : "null")
                .append(", latin='").append(latin != null ? latin : "null").append('\'')
                .append(", cyrillicWord=").append(cyrillicWord != null ? cyrillicWord.toString() : "null")
                .append(", devanagariWord=").append(devanagariWord != null ? devanagariWord.toString() : "null")
                .append(", greekWord=").append(greekWord != null ? greekWord.toString() : "null")
                .append(", thaiWord=").append(thaiWord != null ? thaiWord.toString() : "null")
                .append(", georgianWord=").append(georgianWord != null ? georgianWord.toString() : "null")
                .append(", armenianWord=").append(armenianWord != null ? armenianWord.toString() : "null")
                .append(", word=").append(word != null ? word.getTranslation() : "null")
                .append('}');
        return sb.toString();
    }
}
