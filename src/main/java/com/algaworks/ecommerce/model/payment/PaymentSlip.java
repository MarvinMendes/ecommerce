package com.algaworks.ecommerce.model.payment;

import com.algaworks.ecommerce.model.order.Order;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class PaymentSlip implements Serializable {
    private static final long serialVersionUID = 3567223986414541095L;

    @Id
    private Integer id;
    private String barCode;
    private Integer orderId;
    private StatusPayment status;
}
