package com.gepardec.app.backend.article;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity(name = "ARTICLE")
@Table(name = "ARTICLE", uniqueConstraints =
        {
                @UniqueConstraint(columnNames = "ID")
        }
)
public class Article {

    @Id
    @SequenceGenerator(
            name = "article_id_sequence",
            sequenceName = "article_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "article_id_sequence"
    )
    @Column(name = "ID", nullable = false, updatable = false, unique = true)
    @Setter(value = AccessLevel.NONE)
    private long id;

    @Column(name = "ARTICLE_NAME", nullable = false)
    private String name;

    @Column(name = "PRICE", nullable = false)
    private double price;

    public Article(final String articleName, final double articlePrice) {
        this.name = articleName;
        this.price = articlePrice;
    }
}
