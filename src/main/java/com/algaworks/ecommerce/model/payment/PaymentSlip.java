package com.algaworks.ecommerce.model.payment;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "payment_slip")
public class PaymentSlip extends AbstractPayment implements Serializable {
    private static final long serialVersionUID = 3567223986414541095L;

    @Column(name = "bar_code", nullable = false, length = 100)
    private String barCode;
}
