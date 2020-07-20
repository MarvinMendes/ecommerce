package com.algaworks.ecommerce.model.order;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OrderItemId implements Serializable {
    private static final long serialVersionUID = 7493038957492958533L;

    @EqualsAndHashCode.Include
    @Column(name = "order_id")
    private Integer orderId;

    @EqualsAndHashCode.Include
    @Column(name = "product_id")
    private Integer productId;
}
