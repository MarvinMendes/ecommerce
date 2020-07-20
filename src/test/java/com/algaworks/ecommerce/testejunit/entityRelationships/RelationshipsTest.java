package com.algaworks.ecommerce.testejunit.entityRelationships;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.client.Client;
import com.algaworks.ecommerce.model.order.Invoice;
import com.algaworks.ecommerce.model.order.Order;
import com.algaworks.ecommerce.model.order.OrderItem;
import com.algaworks.ecommerce.model.order.Status;
import com.algaworks.ecommerce.model.payment.PaymentCredit;
import com.algaworks.ecommerce.model.payment.StatusPayment;
import com.algaworks.ecommerce.model.product.Category;
import com.algaworks.ecommerce.model.product.Product;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
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

        Client client = em.find(Client.class, 2);

        Order order = new Order();
        //order.setOrderItem(Stream.of(orderItem).collect(Collectors.toSet()));
        order.setTotal(new BigDecimal(789.90));
        order.setStatus(Status.PAID);
        order.setItems(Stream.of(orderItem).collect(Collectors.toSet()));
        order.setClient(client);

        em.getTransaction().begin();
        em.persist(order);
        em.getTransaction().commit();
        em.clear();

        Order orderSaved = em.find(Order.class, order.getId());
        Assert.assertNotNull(orderSaved.getItems());

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

    @Test
    public void oneToOneOrderCreditTest() {
        Order order = em.find(Order.class, 1);
        PaymentCredit paymentCredit = new PaymentCredit();
        paymentCredit.setNumber("0987-7894-7852-4203");
        paymentCredit.setStatus(StatusPayment.PROCESSING);
        paymentCredit.setOrder(order);

        em.getTransaction().begin();
        em.persist(paymentCredit);
        em.getTransaction().commit();

        em.clear();

        PaymentCredit paymentSaved = em.find(PaymentCredit.class, paymentCredit.getId());

        Assert.assertNotNull(paymentSaved.getOrder());
    }

    @Test
    public void onoToOneOrderInvoiceTest() {
        Order order = em.find(Order.class, 1);
        Invoice invoice = new Invoice();
        invoice.setEmissionDate(new Date());
        invoice.setOrder(order);

        em.getTransaction().begin();
        em.persist(invoice);
        em.getTransaction().commit();
        em.clear();

        em.find(Invoice.class, invoice.getId());

        Assert.assertNotNull(invoice.getOrder());
    }

}
