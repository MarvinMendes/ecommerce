package com.algaworks.ecommerce.model.order;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
public class Invoice implements Serializable {
    private static final long serialVersionUID = -8023575054104174055L;

    @Id
    @EqualsAndHashCode.Include
    private Integer id;
    private Order orderId;
    private String xml;
    private Date emissionDate;
}
