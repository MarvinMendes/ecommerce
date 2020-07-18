package com.algaworks.ecommerce.testejunit.advancedMappings;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.client.Client;
import com.algaworks.ecommerce.model.order.Order;
import com.algaworks.ecommerce.model.order.OrderItem;
import com.algaworks.ecommerce.model.order.OrderItemId;
import com.algaworks.ecommerce.model.order.Status;
import com.algaworks.ecommerce.model.product.Product;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class TestComposePK extends EntityManagerTest {

    @Test
    public void testComposePK() {
        em.getTransaction().begin();

        Client client = em.find(Client.class, 1);
        Product product = em.find(Product.class, 1);

        Order order = new Order();
        order.setClient(client);
        order.setRequestDate(LocalDateTime.now());
        order.setStatus(Status.WAITING);
        order.setTotal(product.getValue());

        em.persist(order);

        em.flush();

        OrderItem orderItem = new OrderItem();
        orderItem.setId(new OrderItemId(order.getId(), product.getId()));
        orderItem.setQuantity(1);
        orderItem.setProductPrice(product.getValue());
        orderItem.setProduct(product);
        orderItem.setOrder(order);

        em.persist(orderItem);

        em.getTransaction().commit();

        em.clear();

        Order orderSaved = em.find(Order.class, order.getId());
        Assert.assertNotNull(orderSaved);
        Assert.assertFalse(orderSaved.getItems().isEmpty());
    }

    @Test
    public void findItem() {
        OrderItem orderItem = em.find(OrderItem.class, new OrderItemId(1, 1));

        Assert.assertNotNull(orderItem);
    }

}
