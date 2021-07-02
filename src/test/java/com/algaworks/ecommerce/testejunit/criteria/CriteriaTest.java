package com.algaworks.ecommerce.testejunit.criteria;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.order.Order;
import com.algaworks.ecommerce.model.order.Status;
import com.algaworks.ecommerce.model.payment.AbstractPayment;
import com.algaworks.ecommerce.model.payment.StatusPayment;
import com.algaworks.ecommerce.model.product.Product;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

public class CriteriaTest extends EntityManagerTest {


        @Test
        public void buscarPorIdentificador() {

            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Order> criteriaQuery = cb.createQuery(Order.class);
            Root<Order> root = criteriaQuery.from(Order.class);

            criteriaQuery.select(root);
            criteriaQuery.where(cb.equal(root.get("id"), 1));


            //String jpql = "select p from Order p where p.id = 1";

            TypedQuery<Order> typedQuery = em.createQuery(criteriaQuery);

            Order order = typedQuery.getSingleResult();

            Assert.assertNotNull(typedQuery);
        }

        @Test
        public void retornaTodosOsProdutos() {
            CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
            Root<Product> root = criteriaQuery.from(Product.class);

            criteriaQuery.select(root);

            criteriaQuery.getOrderList();

            TypedQuery<Product> typedQuery = em.createQuery(criteriaQuery);
            List<Product> resultList = typedQuery.getResultList();

            resultList.stream()
                    .forEach(o -> System.out.println(o.getName()));

            Assert.assertTrue(resultList.size() > 1);
        }


        @Test
        public void testeJoin() {
            CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            CriteriaQuery<Order> criteriaQuery = criteriaBuilder.createQuery(Order.class);
            Root<Order> root = criteriaQuery.from(Order.class);
            Join<Order, AbstractPayment> join = root.join("payment");

            TypedQuery<Order> typedQuery = em.createQuery(criteriaQuery);

            List<Order> resultList = typedQuery.getResultList();

            resultList.forEach(order -> System.out.println(order.getId() + " - " + order.getPayment().getStatus()));

            Assert.assertFalse(resultList.isEmpty());

        }


        @Test
        public void testeJoinComClausulaON() {
            CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            CriteriaQuery<Order> criteriaQuery = criteriaBuilder.createQuery(Order.class);
            Root<Order> root = criteriaQuery.from(Order.class);

            Join<Order, AbstractPayment> join = root.join("payment");
            join.on(criteriaBuilder.equal(join.get("status"), StatusPayment.RECEIVED));

            criteriaQuery.select(root);

            TypedQuery<Order> typedQuery = em.createQuery(criteriaQuery);

            List<Order> resultList = typedQuery.getResultList();

            resultList.forEach(order ->
                    System.out.println(order.getId() + " - " + order.getPayment().getStatus()));

            Assert.assertEquals(1, resultList.size());
        }

}
