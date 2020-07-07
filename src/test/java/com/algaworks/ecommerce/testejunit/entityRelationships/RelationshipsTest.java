package com.algaworks.ecommerce.testejunit.entityRelationships;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.client.Client;
import com.algaworks.ecommerce.model.order.Order;
import com.algaworks.ecommerce.model.order.Status;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class RelationshipsTest extends EntityManagerTest {

    @Test
    public void manyToOneTest(){
        Client client = em.find(Client.class, 2);

        Order order = new Order();
        order.setClient(client);
        order.setTotal(new BigDecimal(10000));
        order.setStatus(Status.WAITING);

        em.getTransaction().begin();
        em.persist(order);
        em.getTransaction().commit();
        em.clear();

        Assert.assertNotNull(order.getClient());

    }

}
