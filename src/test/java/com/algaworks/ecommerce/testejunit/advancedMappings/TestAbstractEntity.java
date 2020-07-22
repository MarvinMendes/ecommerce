package com.algaworks.ecommerce.testejunit.advancedMappings;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.order.Order;
import com.algaworks.ecommerce.model.payment.AbstractPayment;
import com.algaworks.ecommerce.model.payment.PaymentCredit;
import com.algaworks.ecommerce.model.payment.StatusPayment;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TestAbstractEntity extends EntityManagerTest {

    @Test
    public void testAbstract() {
        List<AbstractPayment> payments = em.createQuery("select p from AbstractPayment p").getResultList();

        Assert.assertFalse(payments.isEmpty());
    }

    @Test
    public void savePayment() {
        Order order = em.find(Order.class, 1);

        PaymentCredit paymentCredit = new PaymentCredit();
        paymentCredit.setOrder(order);
        paymentCredit.setCardNumber("123");
        paymentCredit.setStatus(StatusPayment.PROCESSING);

        em.getTransaction().begin();
        em.persist(paymentCredit);
        em.getTransaction().commit();

        em.clear();

        Order orderSaved = em.find(Order.class, order.getId());
        Assert.assertNotNull(orderSaved.getPayment());

    }
}
