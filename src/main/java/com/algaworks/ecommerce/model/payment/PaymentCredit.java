package com.algaworks.ecommerce.model.payment;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "payment_credit")
public class PaymentCredit extends AbstractPayment implements Serializable {
    private static final long serialVersionUID = 1039433612722833998L;

    @Column(name = "card_number", nullable = false, length = 50)
    private String cardNumber;
}
