package com.algaworks.ecommerce.model.product;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
@Getter
@Setter
@Entity
public class Category implements Serializable {
    private static final long serialVersionUID = 2178156383098657931L;

    @Id
    @EqualsAndHashCode.Include
    private Integer id;
    private String name;
    private Integer categoryId;



}



