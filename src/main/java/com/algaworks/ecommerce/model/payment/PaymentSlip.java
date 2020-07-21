package com.algaworks.ecommerce.model.payment;

import com.algaworks.ecommerce.model.commons.EntityBaseCommons;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "payment_slip")
public class PaymentSlip extends EntityBaseCommons implements Serializable {
    private static final long serialVersionUID = 3567223986414541095L;

    @Column(name = "bar_code")
    private String barCode;
    @Column(name = "order_id")
    private Integer orderId;
    @Enumerated(EnumType.STRING)
    private StatusPayment status;
}
