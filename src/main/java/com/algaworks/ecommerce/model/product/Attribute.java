package com.algaworks.ecommerce.model.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Attribute {

    private String name;
    private String value;
}
