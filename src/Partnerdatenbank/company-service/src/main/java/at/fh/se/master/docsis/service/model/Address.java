package at.fh.se.master.docsis.service.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity(name = "ADDRESS")
@Table(name = "ADDRESS", uniqueConstraints =
        {
                @UniqueConstraint(columnNames = "ID")
        }
)
public class Address implements Serializable {
    @Id
    @SequenceGenerator(
            name = "address_id_sequence",
            sequenceName = "address_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "address_id_sequence"
    )
    @Column(name = "ID", nullable = false, updatable = false, unique = true)
    @Setter(value = AccessLevel.NONE)
    private long id;

    @Column(name = "STREET", nullable = false)
    private String street;

    @Column(name = "STREET_NUMBER", nullable = false)
    private int streetNumber;

    @Column(name = "CITY", nullable = false)
    private String city;

    @Column(name = "POSTAL_CODE", nullable = false)
    private String postalCode;

    @Column(name = "COUNTRY", nullable = false)
    private String country;
}
