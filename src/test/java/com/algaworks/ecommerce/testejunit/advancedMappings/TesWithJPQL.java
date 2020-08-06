package com.algaworks.ecommerce.testejunit.advancedMappings;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.client.Client;
import com.algaworks.ecommerce.model.order.Order;
import com.algaworks.ecommerce.model.product.Product;
import org.hibernate.annotations.GenerationTime;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.TypedQuery;
import java.util.List;

public class TesWithJPQL extends EntityManagerTest {

    @Test
    public void testBasicJPQL() {

        TypedQuery<Order> typedQuery = em.
                createQuery("select o from Order o where o.id = 1", Order.class);

        Order singleResult = typedQuery.getSingleResult();

        Assert.assertNotNull(singleResult);
    }

    @Test
    public void selectAttribute() {
        String jpql = "select p.description from Product p";
        String jpqlClient = "select o.client from Order o";

        TypedQuery<String> query = em.createQuery(jpql, String.class);
        List<String> resultList = query.getResultList();

        TypedQuery<Client> queryClient = em.createQuery(jpqlClient, Client.class);
        List<Client> clientResultList = queryClient.getResultList();

        Assert.assertTrue(Client.class.equals(clientResultList.get(0).getClass()));
        Assert.assertTrue(String.class.equals(resultList.get(0).getClass()));
    }
}
