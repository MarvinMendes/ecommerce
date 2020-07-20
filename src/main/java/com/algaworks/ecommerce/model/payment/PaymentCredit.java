package com.algaworks.ecommerce.model.payment;

import com.algaworks.ecommerce.model.order.Order;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "payment_credit")
public class PaymentCredit implements Serializable {
    private static final long serialVersionUID = 1039433612722833998L;

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "order_id")
    private Integer id;
    @MapsId
    @OneToOne(optional = false)
    @JoinColumn(name = "order_id")
    private Order order;
    @Enumerated(EnumType.STRING)
    private StatusPayment status;
    @Column(name = "number")
    private String number;
}
