package com.algaworks.ecommerce.model.product;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "category")
public class Category implements Serializable {
    private static final long serialVersionUID = 2178156383098657931L;

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "category_name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "categoty_father_id")
    private Category categoryFather;
    @OneToMany(mappedBy = "categoryFather")
    private Set<Category> category;
}



