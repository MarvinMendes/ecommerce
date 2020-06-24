package com.algaworks.ecommerce.model.order;

import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Order implements Serializable {
    private static final long serialVersionUID = 354811635865628940L;

    @Id
    @EqualsAndHashCode.Include
    private Integer id;
    private LocalDateTime requestDate;
    private LocalDateTime conclusionDate;
    private Invoice invoice;
    private BigDecimal total;
    private Status status;


}