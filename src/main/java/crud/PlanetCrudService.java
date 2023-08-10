package crud;


import entities.Planet;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class PlanetCrudService {

    private EntityManager entityManager;

    public PlanetCrudService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Planet save(Planet planet) {
        entityManager.getTransaction().begin();
        entityManager.persist(planet);
        entityManager.getTransaction().commit();
        return planet;
    }

    public void deleteById(String id) {
        entityManager.getTransaction().begin();
        Planet planet = entityManager.find(Planet.class, id);
        if (planet != null) {
            entityManager.remove(planet);
        }
        entityManager.getTransaction().commit();
    }

    public Optional<Planet> getById(String id) {
        Planet planet = entityManager.find(Planet.class, id);
        return Optional.ofNullable(planet);
    }
}