package com.algaworks.ecommerce.model.client;

import com.algaworks.ecommerce.model.commons.EntityBaseCommons;
import com.algaworks.ecommerce.model.order.Order;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "client", uniqueConstraints = { @UniqueConstraint(name = "unq_cpf", columnNames = "client_cpf")},
       indexes = { @Index(name = "idx_client_name", columnList = "client_name")})
@SecondaryTable(name = "client_details", pkJoinColumns = @PrimaryKeyJoinColumn(name = "client_id"))
public class Client extends EntityBaseCommons implements Serializable {

    private static final long serialVersionUID = 5378753649905055112L;

    @Column(name = "client_name", nullable = false, length = 100)
    private String name;
    @Column(name = "client_cpf", length = 14, nullable = false)
    private String cpf;
    @Column(table = "client_details")
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(name = "date_of_birth", table = "client_details")
    private Date dateOfBirth;
    @OneToMany(mappedBy = "client")
    private Set<Order> order;
    @ElementCollection
    @MapKeyColumn(name = "type")
    @Column(name = "description")
    @CollectionTable(name = "contact_client", joinColumns = @JoinColumn(name = "client_id"))
    private Map<String, String> contact;
}
