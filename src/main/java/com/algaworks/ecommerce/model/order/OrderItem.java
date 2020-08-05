package com.algaworks.ecommerce.model.order;

import com.algaworks.ecommerce.model.product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_item")
public class OrderItem implements Serializable {
    private static final long serialVersionUID = -1609736855687401318L;

    @EmbeddedId
    private OrderItemId id;
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id",foreignKey = @ForeignKey(name = "fk_order_item_product"), updatable = false, insertable = false)
    private Product product;
    @ManyToOne(optional = false)
    @JoinColumn(name = "order_id",foreignKey = @ForeignKey(name = "fk_order_item_order") , updatable = false, insertable = false)
    private Order order;
    @Column(name = "product_price", nullable = false)
    private BigDecimal productPrice;
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

}
