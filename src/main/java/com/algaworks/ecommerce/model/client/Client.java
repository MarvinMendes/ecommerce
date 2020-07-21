package com.algaworks.ecommerce.model.client;

import com.algaworks.ecommerce.model.order.Order;
import lombok.EqualsAndHashCode;
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
@Table(name = "client")
@SecondaryTable(name = "client_details", pkJoinColumns = @PrimaryKeyJoinColumn(name = "client_id"))
public class Client implements Serializable {

    private static final long serialVersionUID = 5378753649905055112L;

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "client_name")
    private String name;
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
