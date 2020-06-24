package com.algaworks.ecommerce.testejunit;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.order.DeliveryAddress;
import com.algaworks.ecommerce.model.order.Order;
import com.algaworks.ecommerce.model.order.Status;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RegisterOrderTest extends EntityManagerTest {

    @Test
    public void insertOrder() {

        Order order = new Order();
        DeliveryAddress deliveryAddress = new DeliveryAddress();

        deliveryAddress.setId(1);
        deliveryAddress.setNumber("100");
        deliveryAddress.setNeighborhood("Centro");
        deliveryAddress.setStreet("Rua Um");
        deliveryAddress.setZipcode("32150030");
        deliveryAddress.setCity("Belo Horizonte");
        deliveryAddress.setState("MG");

        order.setId(1);
        order.setRequestDate(LocalDateTime.now());
        order.setStatus(Status.WAITING);
        order.setTotal(new BigDecimal(999));
        order.setDeliveryAddress(deliveryAddress);

        em.getTransaction().begin();
        em.persist(order);
        em.getTransaction().commit();
        em.clear();

        Order orderSaved = em.find(Order.class, 1);
        Assert.assertNotNull(orderSaved);
        Assert.assertNotNull(orderSaved.getDeliveryAddress().getCity());

    }
}
