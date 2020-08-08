package com.algaworks.ecommerce.testejunit.advancedMappings;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.client.Client;
import com.algaworks.ecommerce.model.order.Invoice;
import com.algaworks.ecommerce.model.order.Order;
import com.algaworks.ecommerce.model.payment.StatusPayment;
import com.algaworks.ecommerce.model.product.Product;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import java.io.ObjectStreamException;
import java.sql.Timestamp;
import java.util.Date;
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

    @Test
    public void leftJoin() {
        String jpql = "select o from Order o left join o.payment pay";

        TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
        List<Object[]> resultList = query.getResultList();

        Assert.assertFalse(resultList.isEmpty());

    }

    @Test
    public void findProductInOrder() {
        String jpql = "select o from Order o left join o.items i join i.product p where p.id = 1";
        //String jpql = "select o from Order o join o.items i where i.id.productId = 1";

        TypedQuery<Order> query = em.createQuery(jpql, Order.class);
        List<Order> resultList = query.getResultList();

        resultList.forEach(item -> System.out.println("Obj -- " + item.getItems()));

        Assert.assertFalse(resultList.isEmpty());

    }

    @Test
    public void parameterTest(){
        String jpql = "select o from Order o join o.payment p where p.status = ?1";

        TypedQuery<Order> query = em.createQuery(jpql, Order.class);
        TypedQuery<Order> typedQuery = query.setParameter(1, StatusPayment.PROCESSING);
        List<Order> resultList = typedQuery.getResultList();

        resultList.forEach(i -> System.out.println("Payment" + i.getPayment()));
        Assert.assertTrue(resultList.size() == 1);
    }

    @Test
    public void parameterStringTest(){
        String jpql = "select o from Order o join o.payment p where p.id = :orderId and p.status = ?1 ";

        TypedQuery<Order> query = em.createQuery(jpql, Order.class);
        query.setParameter("orderId", 1);
        query.setParameter(1, StatusPayment.PROCESSING);

        List<Order> resultList = query.getResultList();

        Assert.assertTrue(resultList.size() == 1);
    }

    @Test
    public void parameterDateTest(){
        String jpql = "select i from Invoice i where i.emissionDate <= ?1";

        TypedQuery<Invoice> query = em.createQuery(jpql, Invoice.class);
        query.setParameter(1, new Date(), TemporalType.TIMESTAMP);

        List<Invoice> resultList = query.getResultList();

        Assert.assertTrue(resultList.size() == 1);
    }

    @Test
    public void parameterLikeTest(){
        String jpql = "select c from Client c where c.name like concat('%', :name, '%')";

        TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
        query.setParameter("name", 'a');

        List<Object[]> resultList = query.getResultList();

        Assert.assertFalse(resultList.isEmpty());
    }

    @Test
    public void expressions() {
        String jpql = "select p from Product p where p.categories is not empty";

        TypedQuery<Product> query = em.createQuery(jpql, Product.class);

        List<Product> resultList = query.getResultList();

        Assert.assertFalse(resultList.isEmpty());

    }

}
