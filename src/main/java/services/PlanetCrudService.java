package services;


import entities.Planet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class PlanetCrudService {

    private SessionFactory sessionFactory;

    public PlanetCrudService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Planet save(Planet planet) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(planet);

        transaction.commit();
        session.close();
        return planet;
    }

    public void deleteById(String id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Planet planet = session.get(Planet.class, id);
        if (planet != null) {
            session.delete(planet);
        }

        transaction.commit();
        session.close();
    }

    public Optional<Planet> getById(String id) {
        Session session = sessionFactory.openSession();
        Planet planet = session.get(Planet.class, id);
        session.close();
        return Optional.ofNullable(planet);
    }

    public List<Planet> getAll() {
        Session session = sessionFactory.openSession();
        List<Planet> planets = session.createQuery("SELECT p FROM Planet p", Planet.class).getResultList();
        session.close();
        return planets;
    }

    public Planet update(Planet planet) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        planet = (Planet) session.merge(planet);

        transaction.commit();
        session.close();
        return planet;
    }
}
