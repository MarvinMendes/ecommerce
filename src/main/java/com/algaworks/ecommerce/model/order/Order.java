package com.algaworks.ecommerce.model.order;

import com.algaworks.ecommerce.model.client.Client;
import com.algaworks.ecommerce.model.payment.PaymentCredit;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

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
    @ManyToOne(optional = false)
    @JoinColumn(name = "client_id")
    private Client client;
    @OneToMany(mappedBy = "order")
    private Set<OrderItem> items;
    @Column(name = "request_date")
    private LocalDateTime requestDate;
    @Column(name = "conclusion_date")
    private LocalDateTime conclusionDate;
    @OneToOne(mappedBy = "order")
    private Invoice invoice;
    @Column(name = "total")
    private BigDecimal total;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Embedded
    private DeliveryAddress deliveryAddress;
    @OneToOne(mappedBy = "order")
    private PaymentCredit paymentCredit;
}
