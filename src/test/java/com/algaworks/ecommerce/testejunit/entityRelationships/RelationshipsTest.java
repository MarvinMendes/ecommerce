package com.algaworks.ecommerce.testejunit.entityRelationships;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.client.Client;
import com.algaworks.ecommerce.model.order.Order;
import com.algaworks.ecommerce.model.order.OrderItem;
import com.algaworks.ecommerce.model.order.Status;
import com.algaworks.ecommerce.model.product.Category;
import com.algaworks.ecommerce.model.product.Product;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RelationshipsTest extends EntityManagerTest {

    @Test
    public void manyToOneTest(){
        Client client = em.find(Client.class, 2);

        Order order = new Order();
        order.setClient(client);
        order.setTotal(new BigDecimal(10000));
        order.setStatus(Status.WAITING);

        em.getTransaction().begin();
        em.persist(order);
        em.getTransaction().commit();
        em.clear();

        Assert.assertNotNull(order.getClient());

    }

    @Test
    public void manyToOneOrderItems() {
        OrderItem orderItem = new OrderItem();
        orderItem.setProductPrice(new BigDecimal(890));
        orderItem.setQuantity(3);

        Order order = new Order();
        order.setOrderItem(Stream.of(orderItem).collect(Collectors.toSet()));
        order.setTotal(new BigDecimal(789.90));
        order.setStatus(Status.PAID);

        em.getTransaction().begin();
        em.persist(orderItem);
        em.persist(order);
        em.getTransaction().commit();
        em.clear();

        Order orderSaved = em.find(Order.class, order.getId());
        Assert.assertNotNull(orderSaved.getOrderItem());

    }

    @Test
    public void autoRelationships() {
        Category categoryFather = new Category();
        categoryFather.setName("Eletrônicos");

        Category category = new Category();
        category.setName("Celulares");
        category.setCategoryFather(categoryFather);

        em.getTransaction().begin();
        em.persist(categoryFather);
        em.persist(category);
        em.getTransaction().commit();

        em.clear();

        Category categorySaved = em.find(Category.class, category.getId());
        Assert.assertNotNull(categorySaved.getCategoryFather());

        Category categoryFatherSaved = em.find(Category.class, categoryFather.getId());
        Assert.assertFalse(categoryFatherSaved.getCategory().isEmpty());

    }

    @Test
    public void manyToManyTest() {
        Category categoryFather = new Category();
        categoryFather.setName("Eletrônicos");

        Product product = new Product();
        product.setName("IPad");
        product.setCategories(Stream.of(categoryFather).collect(Collectors.toSet()));

        em.getTransaction().begin();
        em.persist(categoryFather);
        em.persist(product);
        em.getTransaction().commit();

        em.clear();

        Category categorySaved = em.find(Category.class, categoryFather.getId());

        Assert.assertFalse(categorySaved.getProducts().isEmpty());

    }

}
