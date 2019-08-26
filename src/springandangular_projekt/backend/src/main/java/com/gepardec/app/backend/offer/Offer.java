package com.gepardec.app.backend.offer;

import com.gepardec.app.backend.common.StatusItem;
import com.gepardec.app.backend.customer.Customer;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Entity(name = "OFFER")
@Table(name = "OFFER", uniqueConstraints =
        {
                @UniqueConstraint(columnNames = "ID")
        }
)
public class Offer implements Serializable {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(
            name = "offer_id_sequence",
            sequenceName = "offer_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "offer_id_sequence"
    )
    @Column(name = "ID", nullable = false, unique = true, updatable = false)
    @Setter(value = AccessLevel.NONE)
    private long id;

    @Column(name = "OFFER_NUMBER", nullable = false, unique = true)
    @Setter(value = AccessLevel.NONE)
    private String offerNumber;

    @Column(name = "OFFER_DATE", nullable = false)
    private Instant offerDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "OFFER_ID")
    @Setter(value = AccessLevel.NONE)
    private Set<OfferItem> offerPositions = new LinkedHashSet<>();

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "CUSTOMER_ID", nullable = false)
    private Customer customer;

    @Embedded
    private StatusItem status;

    public Offer() {
        this.offerNumber = UUID.randomUUID().toString();
    }

    @SuppressWarnings("UnusedReturnValue")
    public boolean addOfferPosition (final OfferItem offerItem) {
        return this.offerPositions.add(offerItem);
    }
}
