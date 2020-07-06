package com.algaworks.ecommerce.model.client;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "client")
public class Client implements Serializable {

    private static final long serialVersionUID = 5378753649905055112L;

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "client_name")
    private String name;
    @Enumerated(EnumType.STRING)
    private Gender gender;

}
