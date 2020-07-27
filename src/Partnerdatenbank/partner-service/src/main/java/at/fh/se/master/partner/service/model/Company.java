package at.fh.se.master.partner.service.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@Entity(name = "COMPANY")
@Table(name = "COMPANY", uniqueConstraints =
        {
                @UniqueConstraint(columnNames = "ID")
        }
)
public class Company {
    @Id
    @SequenceGenerator(
            name = "company_id_sequence",
            sequenceName = "company_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "company_id_sequence"
    )
    @Column(name = "ID", nullable = false, updatable = false, unique = true)
    @Setter(value = AccessLevel.NONE)
    private long id;

    @Column(name = "MANDANT", nullable = false)
    @NotEmpty
    private String mandant;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Valid @NotNull
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinTable(name = "COMPANY_PARTNER_REFERENCE_MAPPING", joinColumns = @JoinColumn(name = "COMPANY_ID"), inverseJoinColumns = @JoinColumn(name = "PARTNER_ID"))
    private List<Partner> partners;

    @Column(name = "KREDITORNR", nullable = false)
    @NotEmpty
    private String creditorNumber;

    @Column(name = "KREDITORNAME", nullable = false)
    @NotEmpty
    private String creditorName;

    @Column(name = "KREDITORSTATUS", nullable = false)
    private String creditorStatus;

    @Column(name = "KONTONR_SAP_ALT")
    @NotEmpty
    private String kontoNrSAPOld;

    @Column(name = "KURZBEZEICHNUNG")
    @NotEmpty
    private String shortName;

    @Column(name = "AEND_ZAEHLER")
    @Min(0)
    private int aendCounter;
}
