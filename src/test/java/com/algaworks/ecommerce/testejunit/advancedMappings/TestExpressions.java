package com.algaworks.ecommerce.testejunit.advancedMappings;

import com.algaworks.ecommerce.EntityManagerTest;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.TypedQuery;
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

}
