package com.algaworks.ecommerce.model.client;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class Client implements Serializable {

    private static final long serialVersionUID = 5378753649905055112L;

    @Id
    private Integer id;
    private String name;
}
