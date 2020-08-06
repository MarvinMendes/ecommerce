package com.algaworks.ecommerce.testejunit.advancedMappings;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.order.Order;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.TypedQuery;
import java.util.List;

public class JoinTest extends EntityManagerTest {

    @Test
    public void joinTest() {
        String jpql = "select o from Order o join o.items items";

        TypedQuery<Order> query = em.createQuery(jpql, Order.class);
        List<Order> resultList = query.getResultList();

        resultList.forEach(order -> System.out.println("order id: " + order.getId() + ", " + order.getItems().getClass().getName()));
        Assert.assertTrue(resultList.size() == 2);

    }

    @Test
    public void joinTestProjection() {
        String jpql = "select o, pay from Order o join o.payment pay";

        TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
        List<Object[]> resultList = query.getResultList();

        resultList.forEach(obj -> System.out.println("obj-1" + obj[0] + "obj-2" + obj[1]));
        Assert.assertTrue(resultList.get(0).length == 2);

    }


}
