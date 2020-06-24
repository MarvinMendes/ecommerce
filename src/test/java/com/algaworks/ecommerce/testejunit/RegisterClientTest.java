package com.algaworks.ecommerce.testejunit;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.client.Client;
import com.algaworks.ecommerce.model.product.Product;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;


public class RegisterClientTest extends EntityManagerTest {

    @Test
    public void insertClient() {

        Client client = new Client();

        client.setId(1);
        client.setName("Fernando da Silva");

        em.getTransaction().begin();
        em.persist(client);
        em.getTransaction().commit();
        em.clear();

        Assert.assertNotNull(client);
        Assert.assertEquals("Fernando da Silva", client.getName());



    }

    @Test
    public void removeClient() {
        Client client = em.find(Client.class, 3);
        em.getTransaction().begin();
        em.remove(client);
        em.getTransaction().commit();

        Client clientRemoved = em.find(Client.class, 3);

        Assert.assertNull(clientRemoved);
    }

    @Test
    public void updateClient() {
        Client client = em.find(Client.class, 2);
        client.setName("Mario Jorge Lopes");

        em.getTransaction().begin();
        em.merge(client);
        em.getTransaction().commit();

        Assert.assertEquals("Mario Jorge Lopes", client.getName());

    }

    @Test
    public void findById() {
        Client client = em.find(Client.class, 2);

        Assert.assertNotNull(client);

    }
}
