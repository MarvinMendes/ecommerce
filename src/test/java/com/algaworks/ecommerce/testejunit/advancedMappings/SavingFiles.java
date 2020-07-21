package com.algaworks.ecommerce.testejunit.advancedMappings;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.order.Invoice;
import com.algaworks.ecommerce.model.order.Order;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;

public class SavingFiles extends EntityManagerTest {

    @Test
    public void saveInvoice() {
        em.getTransaction().begin();
        Order order = em.find(Order.class, 1);

        Invoice invoice = new Invoice();
        invoice.setEmissionDate(new Date());
        invoice.setOrder(order);
        invoice.setXml(loadInvoice());
        em.persist(invoice);
        em.getTransaction().commit();

        em.clear();

        Order orderSaved = em.find(Order.class, order.getId());
        Invoice invoiceSaved = em.find(Invoice.class, invoice.getId());

        Assert.assertNotNull(orderSaved.getInvoice().getXml());
        Assert.assertNotNull(invoiceSaved.getXml());
        Assert.assertTrue(invoiceSaved.getXml().length > 0);

    }


    protected static byte[] loadInvoice() {
        try {
            return SavingFiles.class.getResourceAsStream("/invoice.xml").readAllBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
