package com.algaworks.ecommerce.model.order;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
    private Integer id;
    @Column(name = "product_id")
    private Integer productId;
    @Column(name = "order_id")
    private Integer orderId;
    @Column(name = "product_price")
    private BigDecimal productPrice;
    @Column(name = "quantity")
    private Integer quantity;


}
