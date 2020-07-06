package com.algaworks.ecommerce.model.payment;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "order_id")
    private Integer orderId;
    @Enumerated(EnumType.STRING)
    private StatusPayment status;
    @Column(name = "number")
    private String number;
}
