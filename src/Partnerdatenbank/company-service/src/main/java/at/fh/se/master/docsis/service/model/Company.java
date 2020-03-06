package at.fh.se.master.docsis.service.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
    private String mandant;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinTable(name = "COMPANY_PARTNER_REFERENCE_MAPPING", joinColumns = @JoinColumn(name = "COMPANY_ID"), inverseJoinColumns = @JoinColumn(name = "PARTNER_ID"))
    private List<Partner> partners;

    @Column(name = "KREDITORNR", nullable = false)
    private String creditorNumber;

    @Column(name = "KREDITORNAME", nullable = false)
    private String creditorName;

    @Column(name = "KREDITORSTATUS", nullable = false)
    private Character creditorStatus;

    @Column(name = "KONTONR_SAP_ALT")
    private String kontoNrSAPOld;

    @Column(name = "KURZBEZEICHNUNG")
    private String shortName;

    @Column(name = "AEND_ZAEHLER")
    private int aendCounter;
}
