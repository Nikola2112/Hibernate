package services;


import entities.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class ClientCrudService {

    private SessionFactory sessionFactory;
    public ClientCrudService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public Client save(Client client) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(client);

        transaction.commit();
        session.close();
        return client;
    }

    public void deleteById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Client client = session.get(Client.class, id);
        if (client != null) {
            session.delete(client);
        }

        transaction.commit();
        session.close();
    }

    public Optional<Client> getById(Long id) {
        Session session = sessionFactory.openSession();
        Client client = session.get(Client.class, id);
        session.close();
        return Optional.ofNullable(client);
    }

    public List<Client> getAllClients() {
        Session session = sessionFactory.openSession();
        List<Client> clients = session.createQuery("SELECT c FROM Client c", Client.class).getResultList();
        session.close();
        return clients;
    }

    public Client update(Client client) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        client = (Client) session.merge(client);

        transaction.commit();
        session.close();
        return client;
    }


}
