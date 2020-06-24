package com.algaworks.ecommerce.model.payment;

import com.algaworks.ecommerce.model.order.Order;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class PaymentCredit implements Serializable {
    private static final long serialVersionUID = 1039433612722833998L;

    @Id
    @EqualsAndHashCode.Include
    private Integer id;
    private Order orderId;
    private StatusPayment status;
    private String number;
}
