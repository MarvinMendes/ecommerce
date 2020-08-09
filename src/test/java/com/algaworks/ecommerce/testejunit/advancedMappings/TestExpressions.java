package com.algaworks.ecommerce.testejunit.advancedMappings;

import com.algaworks.ecommerce.EntityManagerTest;
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



}
