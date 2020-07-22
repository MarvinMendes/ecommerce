package com.algaworks.ecommerce.testejunit.advancedMappings;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.payment.AbstractPayment;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TestAbstractEntity extends EntityManagerTest {

    @Test
    public void testAbstract() {
        em.getTransaction().begin();

        List<AbstractPayment> payments = em.createQuery("select p from AbstractPayment p").getResultList();

        Assert.assertFalse(payments.isEmpty());

    }
}
