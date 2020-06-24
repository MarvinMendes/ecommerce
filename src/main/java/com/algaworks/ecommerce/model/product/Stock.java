package com.algaworks.ecommerce.model.product;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class Stock implements Serializable {
    private static final long serialVersionUID = 6217183583803853194L;

    @Id
    @EqualsAndHashCode.Include
    private Integer id;
    private Product productId;
    private Integer quantity;
}
