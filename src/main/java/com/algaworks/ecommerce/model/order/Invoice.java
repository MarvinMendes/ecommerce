package com.algaworks.ecommerce.model.order;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "invoice")
public class Invoice implements Serializable {
    private static final long serialVersionUID = -8023575054104174055L;

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
    private String xml;
    @Column(name = "emission_date")
    private Date emissionDate;

}
