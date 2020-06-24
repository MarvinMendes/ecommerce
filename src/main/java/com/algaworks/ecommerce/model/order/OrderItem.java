package com.algaworks.ecommerce.model.order;

import com.algaworks.ecommerce.model.product.Product;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class OrderItem implements Serializable {
    private static final long serialVersionUID = -1609736855687401318L;

    @Id
    @EqualsAndHashCode.Include
    private Integer id;
    private Product productId;
    private Order orderId;
    private BigDecimal productPrice;
    private Integer quantity;


}
