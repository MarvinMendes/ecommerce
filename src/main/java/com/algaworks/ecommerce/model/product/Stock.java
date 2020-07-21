package com.algaworks.ecommerce.model.product;

import com.algaworks.ecommerce.model.commons.EntityBaseCommons;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "stock")
public class Stock extends EntityBaseCommons implements Serializable {
    private static final long serialVersionUID = 6217183583803853194L;

    @OneToOne(optional = false)
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "quantity")
    private Integer quantity;
}
