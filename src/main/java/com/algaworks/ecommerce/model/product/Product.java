package com.algaworks.ecommerce.model.product;

import com.algaworks.ecommerce.model.commons.EntityBaseCommons;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "product", uniqueConstraints = { @UniqueConstraint(name = "unq_product_name", columnNames = "product_name")},
        indexes = {@Index (name = "idx_product_name", columnList = "product_name")})
public class Product extends EntityBaseCommons implements Serializable {
    private static final long serialVersionUID = -376156493036647753L;

    @Column(name = "product_name", nullable = false, length = 100)
    private String name;
    @Column(name = "product_description", columnDefinition = "varchar(255) not null default 'description'")
    private String description;
    @Column(name = "product_value")
    private BigDecimal value;
    @Column(name = "creation_date", updatable = false)
    private LocalDateTime creationDate;
    @Column(name = "updated_date", insertable = false)
    private LocalDateTime lastUpdatedDate;
    @ManyToMany
    @JoinTable(name = "product_category", joinColumns = @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "fk_product_category")),
                inverseJoinColumns = @JoinColumn(name = "category_id", foreignKey = @ForeignKey(name = "fk_category_product")))
    private Set<Category> categories;
    @OneToOne(mappedBy = "product")
    private Stock stock;
    @ElementCollection
    @Column(name = "tag")
    @CollectionTable(name = "product_tag", joinColumns = @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "fk_product_tags")))
    private Set<String> tags;
    @ElementCollection
    @CollectionTable(name = "product_attribute", joinColumns = @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "fk_product_attributes")))
    private Set<Attribute> attributes;

}
