package com.algaworks.ecommerce.testejunit.advancedMappings;

import com.algaworks.ecommerce.EntityManagerTest;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.TypedQuery;
import java.util.List;

public class TestGroupBy extends EntityManagerTest {


    @Test
    public void groupByCategory() {
        //mostrar quantidade de vendas por categoria

        String jpql = "select c.name, count(c.id) from Category c join c.products group by c.id";

        TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
        List<Object[]> resultList = query.getResultList();

        Assert.assertNotNull(resultList.isEmpty());
    }

}
