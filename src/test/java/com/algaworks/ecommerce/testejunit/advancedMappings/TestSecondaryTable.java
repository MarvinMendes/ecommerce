package com.algaworks.ecommerce.testejunit.advancedMappings;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.client.Client;
import com.algaworks.ecommerce.model.client.Gender;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class TestSecondaryTable extends EntityManagerTest {

    @Test
    public void testSecondary() {
        em.getTransaction().begin();

        Client client = em.find(Client.class, 3);
        client.setGender(Gender.MALE);
        client.setDateOfBirth(new Date());

        em.getTransaction().commit();

        em.clear();

        Client clientSaved = em.find(Client.class, client.getId());
        Assert.assertNotNull(clientSaved.getGender());

    }
}
