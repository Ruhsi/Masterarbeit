package com.gepardec.app.backend.common;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity(name = "DISCOUNT")
@Table(name = "DISCOUNT", uniqueConstraints =
        {
                @UniqueConstraint(columnNames = "ID")
        }
)
public class Discount {

    @Id
    @SequenceGenerator(
            name = "discount_id_sequence",
            sequenceName = "discount_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "discount_id_sequence"
    )
    @Column(name = "ID", nullable = false, updatable = false, unique = true)
    @Setter(value = AccessLevel.NONE)
    private long id;

    @Column(name = "DISCOUNT_NAME", nullable = false)
    private String name;

    public Discount (final String name) {
        this.name = name;
    }
}
