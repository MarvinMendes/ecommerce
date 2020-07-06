package com.algaworks.ecommerce.model.order;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order implements Serializable {
    private static final long serialVersionUID = 354811635865628940L;

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "request_date")
    private LocalDateTime requestDate;
    @Column(name = "conclusion_date")
    private LocalDateTime conclusionDate;
    @Column(name = "invoice_id")
    private Integer invoiceId;
    @Column(name = "total")
    private BigDecimal total;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Embedded
    private DeliveryAddress deliveryAddress;

}
