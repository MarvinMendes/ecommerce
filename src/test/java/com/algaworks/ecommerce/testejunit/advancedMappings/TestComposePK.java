package com.algaworks.ecommerce.testejunit.advancedMappings;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.client.Client;
import com.algaworks.ecommerce.model.order.*;
import com.algaworks.ecommerce.model.payment.PaymentCredit;
import com.algaworks.ecommerce.model.payment.StatusPayment;
import com.algaworks.ecommerce.model.product.Product;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Date;

public class TestComposePK extends EntityManagerTest {

    @Test
    public void testComposePK() {
        em.getTransaction().begin();

        Client client = em.find(Client.class, 2);
        Product product = em.find(Product.class, 1);

        Order order = new Order();
        order.setClient(client);
        order.setCreationDate(LocalDateTime.now());
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
    public void testWithMapsId() {
        Order order = em.find(Order.class, 1);

        Invoice invoice = new Invoice();
        invoice.setOrder(order);
        invoice.setEmissionDate(new Date());
        invoice.setXml(SavingFiles.loadInvoice());

        em.getTransaction().begin();
        em.persist(invoice);
        em.getTransaction().commit();

        em.clear();

        Invoice invoiceSaved = em.find(Invoice.class, order.getId());

        Assert.assertNotNull(invoiceSaved);
        Assert.assertEquals(invoiceSaved.getId(), order.getId());

    }

    @Test
    public void testWithMapsIdPaymentCredit() {
        Order order = em.find(Order.class, 1);

        PaymentCredit paymentCredit = new PaymentCredit();
        paymentCredit.setOrder(order);
        paymentCredit.setStatus(StatusPayment.PROCESSING);
        paymentCredit.setCardNumber("5423 2354 4865 6548");



        em.getTransaction().begin();
        em.persist(paymentCredit);
        em.getTransaction().commit();

        em.clear();

        PaymentCredit paymentCreditSaved = em.find(PaymentCredit.class, order.getId());

        Assert.assertNotNull(paymentCreditSaved);
        Assert.assertEquals(paymentCreditSaved.getId(), order.getId());

    }

}
