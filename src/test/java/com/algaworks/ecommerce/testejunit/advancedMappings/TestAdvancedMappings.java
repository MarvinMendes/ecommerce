package com.algaworks.ecommerce.testejunit.advancedMappings;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.product.Product;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class TestAdvancedMappings extends EntityManagerTest {

    @Test
    public void testUpdatebleDate() {
        Product product = em.find(Product.class, 1);
        product.setCreationDate(LocalDateTime.now());

        em.getTransaction().begin();
        em.merge(product);
        em.getTransaction().commit();

        em.clear();

        Product productSaved = em.find(Product.class, product.getId());

        Assert.assertNotEquals(productSaved.getCreationDate(), LocalDateTime.now());


    }

}
