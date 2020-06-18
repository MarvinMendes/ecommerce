package com.algaworks.ecommerce.testejunit;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.product.Product;
import org.junit.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RegisterTest extends EntityManagerTest {

    @Test
    public void findById() {
        Product product = em.find(Product.class, 1);
        Assert.assertNotNull(product);
    }
}
