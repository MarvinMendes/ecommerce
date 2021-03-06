package com.algaworks.ecommerce.testejunit;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.client.Client;
import com.algaworks.ecommerce.model.order.DeliveryAddress;
import com.algaworks.ecommerce.model.order.Order;
import com.algaworks.ecommerce.model.order.Status;
import org.junit.Assert;
import org.junit.Test;

import javax.swing.event.CaretListener;
import java.beans.Transient;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RegisterOrderTest extends EntityManagerTest {

    @Test
    public void insertOrder() {

        DeliveryAddress deliveryAddress = new DeliveryAddress();

        deliveryAddress.setNumber("100");
        deliveryAddress.setNeighborhood("Centro");
        deliveryAddress.setStreet("Rua Um");
        deliveryAddress.setZipcode("32150030");
        deliveryAddress.setCity("Belo Horizonte");
        deliveryAddress.setState("MG");

        Client client = em.find(Client.class, 3);

        Order order = new Order();

        order.setCreationDate(LocalDateTime.now());
        order.setStatus(Status.WAITING);
        order.setTotal(new BigDecimal(999));
        order.setDeliveryAddress(deliveryAddress);
        order.setClient(client);

        em.getTransaction().begin();
        em.persist(order);
        em.getTransaction().commit();
        em.clear();

        Order orderSaved = em.find(Order.class, order.getId());
        Assert.assertNotNull(orderSaved);
        Assert.assertNotNull(orderSaved.getDeliveryAddress());
        Assert.assertNotNull(orderSaved.getDeliveryAddress().getCity());

    }
}
