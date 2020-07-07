package com.algaworks.ecommerce.testejunit.entityRelationships;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.client.Client;
import com.algaworks.ecommerce.model.order.Order;
import com.algaworks.ecommerce.model.order.OrderItem;
import com.algaworks.ecommerce.model.order.Status;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @Test
    public void manyToOneOrderItems() {
        OrderItem orderItem = new OrderItem();
        orderItem.setProductPrice(new BigDecimal(890));
        orderItem.setQuantity(3);

        Order order = new Order();
        order.setOrderItem(Stream.of(orderItem).collect(Collectors.toSet()));
        order.setTotal(new BigDecimal(789.90));
        order.setStatus(Status.PAID);

        em.getTransaction().begin();
        em.persist(orderItem);
        em.persist(order);
        em.getTransaction().commit();
        em.clear();

        Order orderSaved = em.find(Order.class, 1);
        Assert.assertNotNull(orderSaved.getOrderItem());

    }

}
