package unitTests;

import crud.ClientCrudService;
import entities.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;


public class ClientCrudServiceTest {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private ClientCrudService clientCrudService;

    @BeforeEach
    public void setUp() {
        entityManagerFactory = Persistence.createEntityManagerFactory(null);
        entityManager = entityManagerFactory.createEntityManager();
        clientCrudService = new ClientCrudService(entityManager);

    }
    @Test
    public void testClientCrudOperations() {
        Client client = new Client();
        client.setName("Test Client");


        client = clientCrudService.save(client);
        Optional<Client> fetchedClient = clientCrudService.getById(client.getId());
        Assertions.assertTrue(fetchedClient.isPresent());
        Assertions.assertEquals("Test Client", fetchedClient.get().getName());

     
        clientCrudService.deleteById(client.getId());
        fetchedClient = clientCrudService.getById(client.getId());
        Assertions.assertFalse(fetchedClient.isPresent());
    }
}
