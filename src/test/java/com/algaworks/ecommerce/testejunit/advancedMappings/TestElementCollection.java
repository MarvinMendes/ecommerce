package com.algaworks.ecommerce.testejunit.advancedMappings;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.client.Client;
import com.algaworks.ecommerce.model.product.Attribute;
import com.algaworks.ecommerce.model.product.Product;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestElementCollection extends EntityManagerTest {

    @Test
    public void testElement() {
        Product product = em.find(Product.class, 1);

        product.setTags(Stream.of("Kindle", "Amazon", "Livro eletrônico", "Ebook").collect(Collectors.toSet()));

        em.getTransaction().begin();
        em.merge(product);
        em.getTransaction().commit();

        em.clear();

        Product productSaved = em.find(Product.class, 1);

        Assert.assertFalse(productSaved.getTags().isEmpty());

    }
    @Test
    public void testElementEmbeddable() {
        Product product = em.find(Product.class, 1);

        product.setAttributes(Stream.of(new Attribute("Tela", "320 x 600")).collect(Collectors.toSet()) );

        em.getTransaction().begin();
        em.merge(product);
        em.getTransaction().commit();

        em.clear();

        Product productSaved = em.find(Product.class, 1);

        Assert.assertFalse(productSaved.getAttributes().isEmpty());
    }

    @Test
    public void testElementMap() {
        em.getTransaction().begin();
        Client client = em.find(Client.class, 2);

        client.setContact(Collections.singletonMap("email", "mario.jorge@email.com"));

        em.getTransaction().commit();

        em.clear();

        Client clientSaved = em.find(Client.class, client.getId());

        Assert.assertEquals("mario.jorge@email.com" ,clientSaved.getContact().get("email"));
    }


}
