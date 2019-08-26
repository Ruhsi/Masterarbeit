package com.gepardec.app.backend.order;

import com.gepardec.app.backend.article.Article;
import com.gepardec.app.backend.common.Discount;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity(name = "ORDERS_ITEM")
@Table(name = "ORDERS_ITEM", uniqueConstraints =
        {
                @UniqueConstraint(columnNames = "ID")
        }
)
public class OrdersItem implements Serializable {

    @Id
    @SequenceGenerator(
            name = "orderitem_id_sequence",
            sequenceName = "orderitem_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ooreritem_id_sequence"
    )
    @Column(name = "ID", nullable = false, updatable = false, unique = true)
    @Setter(value = AccessLevel.NONE)
    private long id;

    //    @Column(name = "OFFER_ID", nullable = false, updatable = false)
    //    private long offerId;

        @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
        @JoinColumn(name = "ARTICLE_ID", nullable = false)
    private Article article;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinTable(name = "DISCOUNT_ORDER_ITEM_REFERENCE_MAPPING", joinColumns = @JoinColumn(name = "ORDER_ITEM_ID"), inverseJoinColumns = @JoinColumn(name = "DISCOUNT_ID"))
    @Setter(value = AccessLevel.NONE)
    private Set<Discount> discountList = new LinkedHashSet<>();

    @SuppressWarnings("UnusedReturnValue")
    public boolean addDiscount (final Discount discount) {
        return this.discountList.add(discount);
    }

    @Column(name = "QTY", nullable = false)
    private int quantity;

    public void increaseQuantity() {
        this.quantity = ++this.quantity;
    }

    public void decreaseQuantity() {
        if(this.quantity > 0) {
            this.quantity = --this.quantity;
        }
    }
}
