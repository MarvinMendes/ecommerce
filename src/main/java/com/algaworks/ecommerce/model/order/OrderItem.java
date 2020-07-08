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

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id")
    private Product productId;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order orderId;
    @Column(name = "product_price")
    private BigDecimal productPrice;
    @Column(name = "quantity")
    private Integer quantity;


}
