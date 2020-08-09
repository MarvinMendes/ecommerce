package com.algaworks.ecommerce.testejunit.advancedMappings;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.client.Client;
import com.algaworks.ecommerce.model.order.Order;
import com.algaworks.ecommerce.model.product.Product;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class TestExpressions extends EntityManagerTest {

    @Test
    public void testWithDate() {
        String jpql = "select o from Order o where o.creationDate > :value";

        TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
        query.setParameter("value", LocalDateTime.now().minusDays(2));

        List<Object[]> resultList = query.getResultList();

        Assert.assertFalse(resultList.isEmpty());

    }

    @Test
    public void testBetween() {
        String jpql = "select p from Product p where p.value between :min and :max";

        TypedQuery<Product> query = em.createQuery(jpql, Product.class);
        query.setParameter("min", new BigDecimal(499));
        query.setParameter("max", new BigDecimal(1500));

        List<Product> resultList = query.getResultList();

        Assert.assertFalse(resultList.isEmpty());

    }

    @Test
    public void testDif() {
        String jpql = "select p from Product p where p.id <> 1";

        TypedQuery<Product> query = em.createQuery(jpql, Product.class);
        List<Product> resultList = query.getResultList();

        Assert.assertFalse(resultList.isEmpty());

    }

    @Test
    public void conditionals() {
        String jpql = "select o from Order o where o.status = 'WAITING' and o.total > 100";

        TypedQuery<Order> query = em.createQuery(jpql, Order.class);
        List<Order> resultList = query.getResultList();

        Assert.assertFalse(resultList.isEmpty());

    }

    @Test
    public void ordering() {
        String jpql = "select c from Client c order by c.name asc";

        TypedQuery<Client> query = em.createQuery(jpql, Client.class);
        List<Client> resultList = query.getResultList();

        Assert.assertFalse(resultList.isEmpty());

        resultList.forEach(c -> System.out.println(c.getId() + ", " + c.getName()));
    }


}
