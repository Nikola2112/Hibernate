package crud;


import entities.Client;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class ClientCrudService {

    private EntityManager entityManager;

    public ClientCrudService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Client save(Client client) {
        entityManager.getTransaction().begin();
        entityManager.persist(client);
        entityManager.getTransaction().commit();
        return client;
    }

    public void deleteById(Long id) {
        entityManager.getTransaction().begin();
        Client client = entityManager.find(Client.class, id);
        if (client != null) {
            entityManager.remove(client);
        }
        entityManager.getTransaction().commit();
    }

    public Optional<Client> getById(Long id) {
        Client client = entityManager.find(Client.class, id);
        return Optional.ofNullable(client);
    }
}
