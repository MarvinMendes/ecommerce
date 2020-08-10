package com.algaworks.ecommerce.testejunit.advancedMappings;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.client.Client;
import com.algaworks.ecommerce.model.client.Gender;
import com.algaworks.ecommerce.model.order.*;
import com.algaworks.ecommerce.model.product.Category;
import com.algaworks.ecommerce.model.product.Product;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CascadeTest extends EntityManagerTest {

    @Test
    public void testCascade() {
        Product product = em.find(Product.class, 1);
        Client client = em.find(Client.class, 1);

        Order order = new Order();
        order.setCreationDate(LocalDateTime.now());
        order.setClient(client);
        order.setStatus(Status.WAITING);
        order.setTotal(product.getValue());

        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);
        orderItem.setProduct(product);
        orderItem.setProductPrice(product.getValue());
        orderItem.setQuantity(1);
        orderItem.setId(new OrderItemId());

        order.setItems(Stream.of(orderItem).collect(Collectors.toSet()));

        em.getTransaction().begin();
        em.persist(order);
        em.getTransaction().commit();

        Order orderSaved = em.find(Order.class, order.getId());

        Assert.assertNotNull(orderSaved);
        Assert.assertFalse(orderSaved.getItems().isEmpty());

    }

    @Test
    public void testProductCategory() {
        Product product = new Product();
        product.setTags(Stream.of("Eletrônicos", "Computadores").collect(Collectors.toSet()));
        product.setCreationDate(LocalDateTime.now());
        product.setName("Acer Nitro 5");
        product.setDescription("Nova geração de PC-Gamer da Acer");
        product.setValue(BigDecimal.TEN);

        Category category = new Category();
        category.setName("Eletrônicos");

        product.setCategories(Stream.of(category).collect(Collectors.toSet()));

        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();

        em.clear();

        Category categorySaved = em.find(Category.class, category.getId());

        Assert.assertNotNull(categorySaved);

    }

    @Test
    public void persistOrderClient() {
        Client client = new Client();
        client.setName("Francisco de Assis");
        client.setGender(Gender.NONBINARY);
        client.setCpf("1234456789");

        Order order = new Order();
        order.setClient(client);
        order.setStatus(Status.WAITING);
        order.setTotal(BigDecimal.TEN);
        order.setCreationDate(LocalDateTime.now());

        em.getTransaction().begin();
        em.persist(order);
        em.getTransaction().commit();

        em.clear();

        Client clientSaved = em.find(Client.class, client.getId());
        Assert.assertNotNull(clientSaved);

    }


    @Test
    public void updateOrder() {
        em.getTransaction().begin();
        Order order = em.find(Order.class, 1);
        Product product = new Product();
        product.setName("IPhone");
        product.setDescription("Novo IPhone");
        product.setCreationDate(LocalDateTime.now());
        product.setValue(new BigDecimal(10000));

        em.persist(product);
        em.getTransaction().commit();
        em.clear();

        OrderItem orderItem = new OrderItem();
        orderItem.setId(new OrderItemId());
        orderItem.setQuantity(4);
        orderItem.getId().setOrderId(order.getId());
        orderItem.getId().setProductId(product.getId());
        orderItem.setProduct(product);
        orderItem.setOrder(order);
        orderItem.setProductPrice(product.getValue());

        order.setItems(Stream.of(orderItem).collect(Collectors.toSet()));


        em.getTransaction().begin();
        em.merge(order);
        em.getTransaction().commit();
        em.clear();

        OrderItem orderItemSaved = em.find(OrderItem.class, orderItem.getId());
        Order orderSaved = em.find(Order.class, order.getId());

        Assert.assertNotNull(orderSaved.getItems());
        Assert.assertTrue(orderItemSaved.getQuantity().equals(4));

    }


    @Test
    public void testProductCategoryCascade() {
        Product product = em.find(Product.class, 3);
        product.setValue(new BigDecimal(9000));

        Category category = em.find(Category.class, 1);
        category.setName("Celulares");
        category.setProducts(Stream.of(product).collect(Collectors.toSet()));

        product.setCategories(Stream.of(category).collect(Collectors.toSet()));

        em.getTransaction().begin();
        em.merge(product);
        em.getTransaction().commit();

        em.clear();

        Product productSaved = em.find(Product.class, product.getId());
        Assert.assertNotNull(productSaved.getCategories());


    }


}
