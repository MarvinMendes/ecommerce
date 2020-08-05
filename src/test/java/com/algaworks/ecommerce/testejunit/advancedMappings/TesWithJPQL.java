package com.algaworks.ecommerce.testejunit.advancedMappings;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.order.Order;
import org.hibernate.annotations.GenerationTime;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.TypedQuery;

public class TesWithJPQL extends EntityManagerTest {

    @Test
    public void testBasicJPQL() {

        TypedQuery<Order> typedQuery = em.
                createQuery("select o from Order o where o.id = 1", Order.class);

        Order singleResult = typedQuery.getSingleResult();

        Assert.assertNotNull(singleResult);


    }
}
