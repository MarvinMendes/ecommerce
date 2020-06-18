package com.algaworks.ecommerce;

import com.algaworks.ecommerce.model.product.Product;
import org.junit.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerTest {
    protected static EntityManagerFactory emf;

    protected static EntityManager em;

    @BeforeClass
    public static void setUpBeforeClass() {
        emf = Persistence.createEntityManagerFactory("Ecommerce-PU");
    }

    @AfterClass
    public static void tearDownClass() {
        emf.close();
    }

    @Before
    public void setUp() {
        em = emf.createEntityManager();
    }

    @After
    public void tearDown() {
        emf.close();
    }

}
