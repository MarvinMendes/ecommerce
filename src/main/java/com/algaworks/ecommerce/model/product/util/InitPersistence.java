package com.algaworks.ecommerce.model.product.util;

import com.algaworks.ecommerce.model.product.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InitPersistence {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("Ecommerce-PU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Product produto = entityManager.find(Product.class, 1);
        System.out.println(produto.getName());

        entityManager.close();
        entityManagerFactory.close();
    }
}
