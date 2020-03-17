package at.fh.se.master.partner.service.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@Entity(name = "LINK")
@Table(name = "LINK", uniqueConstraints =
        {
                @UniqueConstraint(columnNames = "ID")
        }
)
public class Link {
    @Id
    @SequenceGenerator(
            name = "partner_id_sequence",
            sequenceName = "partner_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "partner_id_sequence"
    )
    @Column(name = "ID", nullable = false, updatable = false, unique = true)
    @Setter(value = AccessLevel.NONE)
    private long id;

    @Column(name = "PARTNER_ID", nullable = false, updatable = false)
    @Min(0)
    private long partnerId;

    @Column(name = "LINK", nullable = false)
    @NotEmpty
    private String link;

    @Column(name = "LINK_DESCRIPTION", nullable = false)
    @NotEmpty
    private String linkDescription;
}
