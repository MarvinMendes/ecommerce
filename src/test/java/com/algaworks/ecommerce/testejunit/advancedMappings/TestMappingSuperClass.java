package com.algaworks.ecommerce.testejunit.advancedMappings;

import com.algaworks.ecommerce.EntityManagerTest;
import com.algaworks.ecommerce.model.client.Client;
import com.algaworks.ecommerce.model.client.Gender;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.Date;

public class TestMappingSuperClass extends EntityManagerTest {

    @Test
    public void saveClient() {
        em.getTransaction().begin();
        Client client = new Client();
        client.setDateOfBirth(new Date());
        client.setGender(Gender.NOTBINARY);
        client.setName("Rubens de Oliveira");
        client.setContact(Collections.singletonMap("email", "rubens.oliveira@email.com"));
        em.persist(client);
        em.getTransaction().commit();

        em.clear();

        Client clientSaved = em.find(Client.class, client.getId());

        Assert.assertNotNull(clientSaved);
    }
}
