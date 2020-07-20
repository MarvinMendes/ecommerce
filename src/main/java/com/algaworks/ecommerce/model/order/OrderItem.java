package com.algaworks.ecommerce.model.order;

import com.algaworks.ecommerce.model.product.Product;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "order_item")
public class OrderItem implements Serializable {
    private static final long serialVersionUID = -1609736855687401318L;

    @EmbeddedId
    private OrderItemId id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", updatable = false, insertable = false)
    private Product product;
    @ManyToOne(optional = false)
    @JoinColumn(name = "order_id", updatable = false, insertable = false)
    private Order order;
    @Column(name = "product_price")
    private BigDecimal productPrice;
    @Column(name = "quantity")
    private Integer quantity;

}
