package com.algaworks.ecommerce.model.order;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@Embeddable
public class DeliveryAddress implements Serializable {
    private static final long serialVersionUID = 666906474727026317L;

    @Column(name = "zipcode", length = 9)
    private String zipcode;
    @Column(name = "street", length = 50)
    private String street;
    @Column(name = "number", length = 10)
    private String number;
    @Column(name = "neighborhood", length = 100)
    private String neighborhood;
    @Column(name = "city", length = 50)
    private String city;
    @Column(name = "state", length = 50)
    private String state;
}
