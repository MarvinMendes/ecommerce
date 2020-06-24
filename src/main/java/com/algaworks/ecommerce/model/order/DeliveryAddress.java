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

    @Column(name = "zipcode")
    private String zipcode;
    @Column(name = "street")
    private String street;
    @Column(name = "number")
    private String number;
    @Column(name = "neighborhood")
    private String neighborhood;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
}
