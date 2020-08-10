package com.algaworks.ecommerce.testejunit.advancedMappings;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.client.Client;
import com.algaworks.ecommerce.model.order.Order;
import com.algaworks.ecommerce.model.product.Category;
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

    @Test
    public void pageableTest() {
        String jpql = "select c from Category c order by c.name";

        TypedQuery<Category> query = em.createQuery(jpql, Category.class);
        query.setFirstResult(3);
        query.setMaxResults(2);

        List<Category> resultList = query.getResultList();
        Assert.assertFalse(resultList.isEmpty());

        resultList.forEach(i -> System.out.println(i.getId() + ", " + i.getName()));

    }

    @Test
    public void functionStrings() {

        String jpql = "select c.name, concat('Categorias: ', c.name) from Category c";
        String jpql1 = "select c.name, c.id from Category c where length(c.name) > 8";
        String jpql2 = "select c.name, locate('a', c.name) from Category c";
        String jpql3 = "select c.name, substring(c.name, 1, 2) from Category c";
        String jpql4 = "select c.name, lower(c.name) from Category c"; // same to upper
        String jpql5 = "select c.name, trim(c.name) from Category c";

        TypedQuery<Object[]> query = em.createQuery(jpql1, Object[].class);
        List<Object[]> resultList = query.getResultList();

        Assert.assertFalse(resultList.isEmpty());

        resultList.forEach(i -> System.out.println(i[0] + " - " + i[1]));
    }


}
