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
        client.setGender(Gender.NONBINARY);
        client.setName("Rubens de Oliveira");
        client.setContact(Collections.singletonMap("email", "rubens.oliveira@email.com"));
        em.persist(client);

        Client client1 = new Client();
        client1.setDateOfBirth(new Date());
        client1.setGender(Gender.MALE);
        client1.setName("Rafael Fernandes");
        client1.setContact(Collections.singletonMap("email", "rafael.fernandes@email.com"));
        em.persist(client1);
        em.getTransaction().commit();

        em.clear();

        Client clientSaved = em.find(Client.class, client.getId());
        Client clientSaved1 = em.find(Client.class, client1.getId());

        Assert.assertNotNull(clientSaved);
        Assert.assertNotNull(clientSaved1);

    }
}
