package com.algaworks.ecommerce.model.payment;

import com.algaworks.ecommerce.model.commons.EntityBaseCommons;
import com.algaworks.ecommerce.model.order.Order;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "payment")
public abstract class AbstractPayment extends EntityBaseCommons {

    @MapsId
    @OneToOne(optional = false)
    @JoinColumn(name = "order_id")
    private Order order;

    @Enumerated(EnumType.STRING)
    private StatusPayment status;

}
