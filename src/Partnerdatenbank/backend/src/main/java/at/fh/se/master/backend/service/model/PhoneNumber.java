package at.fh.se.master.backend.service.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity(name = "PHONENUMBER")
@Table(name = "PHONENUMBER", uniqueConstraints =
        {
                @UniqueConstraint(columnNames = "ID")
        }
)
public class PhoneNumber implements Serializable {
    @Id
    @SequenceGenerator(
            name = "phonenumber_id_sequence",
            sequenceName = "phonenumber_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "phonenumber_id_sequence"
    )
    @Column(name = "ID", nullable = false, updatable = false, unique = true)
    @Setter(value = AccessLevel.NONE)
    private long id;

    @Column(name = "PHONE_NUMBER", nullable = false)
    private String phoneNumber;

    @Column(name = "IS_PRIVATE", nullable = false)
    private boolean isPrivate;
}
