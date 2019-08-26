package com.gepardec.app.backend.order;

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
@Entity(name = "ORDERS")
@Table(name = "ORDERS", uniqueConstraints =
        {
                @UniqueConstraint(columnNames = "ID")
        }
)
public class Orders implements Serializable {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(
            name = "orders_id_sequence",
            sequenceName = "orders_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "orders_id_sequence"
    )
    @Column(name = "ID",
            unique = true,
            updatable = false,
            nullable = false)
    @Setter(value = AccessLevel.NONE)
    private long id;

    @Column(name = "ORDERS_NUMBER", nullable = false, unique = true)
    @Setter(value = AccessLevel.NONE)
    private String orderNumber;

    @Column(name = "ORDERS_DATE", nullable = false)
    private Instant orderDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "ORDER_ID")
    @Setter(value = AccessLevel.NONE)
    private Set<OrdersItem> orderPositions = new LinkedHashSet<>();

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "CUSTOMER_ID", nullable = false)
    private Customer customer;

    @Embedded
    private StatusItem status;

    public Orders () {
        this.orderNumber = UUID.randomUUID().toString();
    }

    public boolean addOrderPosition (final OrdersItem orderItem) {
        return this.orderPositions.add(orderItem);
    }
}
