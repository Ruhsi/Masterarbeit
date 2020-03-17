package at.fh.se.master.partner.service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity(name = "PARTNER")
@Table(name = "PARTNER", uniqueConstraints =
        {
                @UniqueConstraint(columnNames = "ID")
        }
)
public class Partner implements Serializable {
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

    @Column(name = "TITLE_BEFORE")
    private String titleBefore;

    @Column(name = "TITLE_AFTER")
    private String titleAfter;

    @Column(name = "FIRSTNAME", nullable = false)
    @NotEmpty
    private String firstname;

    @Column(name = "LASTNAME", nullable = false)
    @NotEmpty
    private String lastname;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinTable(name = "PARTNER_MAILADDRESS_REFERENCE_MAPPING", joinColumns = @JoinColumn(name = "PARTNER_ID"), inverseJoinColumns = @JoinColumn(name = "MAILADDRESS_ID"))
    private Set<MailAddress> mailadresses;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinTable(name = "PARTNER_PHONE_NUMBER_REFERENCE_MAPPING", joinColumns = @JoinColumn(name = "PARTNER_ID"), inverseJoinColumns = @JoinColumn(name = "PHONE_NUMBER_ID"))
    private Set<PhoneNumber> phoneNumbers;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Valid
    private Address address;

    @Column(name = "TOPIC", nullable = false)
    @NotEmpty
    private String topic;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "COMPANY_PARTNER_REFERENCE_MAPPING", joinColumns = @JoinColumn(name = "PARTNER_ID"), inverseJoinColumns = @JoinColumn(name = "COMPANY_ID"))
    @JsonIgnore
    private Company company;
}
