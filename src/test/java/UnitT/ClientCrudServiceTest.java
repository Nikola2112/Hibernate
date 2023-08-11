package UnitT;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import services.ClientCrudService;
import entities.Client;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class ClientCrudServiceTest {

    private SessionFactory sessionFactory;
    private ClientCrudService clientCrudService;

    @Before
    public void setup() {
        sessionFactory = new Configuration()
                .configure("hibernate.properties")
                .addAnnotatedClass(Client.class)
                .buildSessionFactory();

        clientCrudService = new ClientCrudService(sessionFactory);
    }

    @After
    public void tearDown() {
        sessionFactory.close();
    }

    @Test
    public void testSaveAndGetById() {
        Client client = new Client();
        client.setName("John Doe");

        Client savedClient = clientCrudService.save(client);
        assertNotNull(savedClient.getId());

        Optional<Client> fetchedClient = clientCrudService.getById(savedClient.getId());
        assertTrue(fetchedClient.isPresent());
        assertEquals("John Doe", fetchedClient.get().getName());
    }

    @Test
    public void testDelete() {
        Client client = new Client();
        client.setName("Jane Smith");

        Client savedClient = clientCrudService.save(client);

        clientCrudService.deleteById(savedClient.getId());

        Optional<Client> deletedClient = clientCrudService.getById(savedClient.getId());
        assertFalse(deletedClient.isPresent());
    }

    @Test
    public void testGetAllClients() {
        List<Client> clients = clientCrudService.getAllClients();
        assertNotNull(clients);
        int initialSize = clients.size();

        Client client1 = new Client();
        client1.setName("Alice");

        Client client2 = new Client();
        client2.setName("Bob");

        clientCrudService.save(client1);
        clientCrudService.save(client2);

        clients = clientCrudService.getAllClients();
        assertEquals(initialSize + 2, clients.size());
    }

    @Test
    public void testUpdate() {
        Client client = new Client();
        client.setName("Initial Name");

        Client savedClient = clientCrudService.save(client);

        savedClient.setName("Updated Name");
        clientCrudService.update(savedClient);

        Optional<Client> updatedClient = clientCrudService.getById(savedClient.getId());
        assertTrue(updatedClient.isPresent());
        assertEquals("Updated Name", updatedClient.get().getName());
    }
}
