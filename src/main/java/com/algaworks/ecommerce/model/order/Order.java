package com.algaworks.ecommerce.model.order;

import com.algaworks.ecommerce.model.client.Client;
import com.algaworks.ecommerce.model.commons.EntityBaseCommons;
import com.algaworks.ecommerce.model.payment.AbstractPayment;
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
public class Order extends EntityBaseCommons implements Serializable {
    private static final long serialVersionUID = 354811635865628940L;


    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", foreignKey = @ForeignKey(name = "fk_order_client"))
    private Client client;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<OrderItem> items;
    @Column(name = "request_date")
    private LocalDateTime requestDate;
    @Column(name = "conclusion_date")
    private LocalDateTime conclusionDate;
    @Column(name = "update_date")
    private LocalDateTime updateDate;
    @OneToOne(mappedBy = "order")
    private Invoice invoice;
    @Column(name = "total", nullable = false)
    private BigDecimal total;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;
    @Embedded
    private DeliveryAddress deliveryAddress;
    @OneToOne(mappedBy = "order")
    private AbstractPayment payment;

    public void calcularTotal() {
        if (items != null) {
            total = items.stream().map(items -> new BigDecimal(items.getQuantity()).multiply(items.getProductPrice()))
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        } else {
            total = BigDecimal.ZERO;
        }
    }

    @PrePersist
    public void aoPersistir() {
        requestDate = LocalDateTime.now();
        calcularTotal();
    }

    @PreUpdate
    public void aoAtualizar() {
        updateDate = LocalDateTime.now();
        calcularTotal();
    }

    @PostPersist
    public void aposPersistir() {
        System.out.println("Após persistir Pedido.");
    }

    @PostUpdate
    public void aposAtualizar() {
        System.out.println("Após atualizar Pedido.");
    }

    @PreRemove
    public void aoRemover() {
        System.out.println("Antes de remover Pedido.");
    }

    @PostRemove
    public void aposRemover() {
        System.out.println("Após remover Pedido.");
    }

    @PostLoad
    public void aoCarregar() {
        System.out.println("Após carregar o Pedido.");
    }
}
