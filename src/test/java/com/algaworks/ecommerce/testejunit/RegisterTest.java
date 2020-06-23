package com.algaworks.ecommerce.testejunit;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.product.Product;
import org.junit.*;
import org.junit.experimental.theories.suppliers.TestedOn;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class RegisterTest extends EntityManagerTest {

    @Test
    public void insertObject() {
        Product product = new Product();
        product.setId(2);
        product.setName("Camera Canon");
        product.setDescription("A melhor definição para suas fotos.");
        product.setValue(new BigDecimal(5000));

        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();

        em.clear();

        Assert.assertNotNull(product);
    }

    @Test
    public void removeObject() {
        Product product = em.find(Product.class, 3);
        em.getTransaction().begin();
        em.remove(product);
        em.getTransaction().commit();

        Product productVerified = em.find(Product.class, 3);

        Assert.assertNull(productVerified);
    }

    @Test
    public void updateObject() {
        Product product = em.find(Product.class, 1);

        product.setName("Kindle Paperwhite 2° Geração");
        product.setValue(new BigDecimal(599));

        em.getTransaction().begin();
        em.merge(product);
        em.getTransaction().commit();

        Assert.assertNotNull(product);
        Assert.assertEquals("Kindle Paperwhite 2° Geração", product.getName());
    }

    @Test
    public void findById() {
        Product product = em.find(Product.class, 1);
        Assert.assertNotNull(product);
    }
}
