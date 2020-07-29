package com.algaworks.ecommerce.model.order;

import com.algaworks.ecommerce.model.commons.EntityBaseCommons;
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
public class Invoice extends EntityBaseCommons implements Serializable {
    private static final long serialVersionUID = -8023575054104174055L;

    @MapsId
    @OneToOne(optional = false)
    @JoinColumn(name = "order_id", foreignKey = @ForeignKey(name = "fk_invoice_order"))
    private Order order;
    @Lob
    @Column(nullable = false)
    private byte[] xml;
    @Column(name = "emission_date", nullable = false)
    private Date emissionDate;

}
