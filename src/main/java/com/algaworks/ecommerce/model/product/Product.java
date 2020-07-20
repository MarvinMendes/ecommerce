package com.algaworks.ecommerce.model.product;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product implements Serializable {
    private static final long serialVersionUID = -376156493036647753L;

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "product_name")
    private String name;
    @Column(name = "product_description")
    private String description;
    @Column(name = "product_value")
    private BigDecimal value;
    @Column(name = "creation_date", updatable = false)
    private LocalDateTime creationDate;
    @Column(name = "updated_date", insertable = false)
    private LocalDateTime lastUpdatedDate;
    @ManyToMany
    @JoinTable(name = "product_category", joinColumns = @JoinColumn(name = "product_id"),
                inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;
    @OneToOne(mappedBy = "product")
    private Stock stock;
}
