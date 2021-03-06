package at.fh.se.master.partner.service.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity(name = "MAILADDRESS")
@Table(name = "MAILADDRESS", uniqueConstraints =
        {
                @UniqueConstraint(columnNames = "ID")
        }
)
public class MailAddress implements Serializable {
    @Id
    @SequenceGenerator(
            name = "mailaddress_id_sequence",
            sequenceName = "mailaddress_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "mailaddress_id_sequence"
    )
    @Column(name = "ID", nullable = false, updatable = false, unique = true)
    @Setter(value = AccessLevel.NONE)
    private long id;

    @Column(name = "MAIL_ADDRESS", nullable = false)
    @NotEmpty
    private String mailAddress;

    @Column(name = "IS_PRIVATE", nullable = false)
    private boolean isPrivate;
}
