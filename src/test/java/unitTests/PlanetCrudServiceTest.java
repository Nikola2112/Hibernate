package unitTests;

import crud.PlanetCrudService;
import entities.Planet;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class PlanetCrudServiceTest {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private PlanetCrudService planetCrudService;

    @BeforeEach
    public void setUp() {
        entityManagerFactory = Persistence.createEntityManagerFactory(null);
        entityManager = entityManagerFactory.createEntityManager();
        planetCrudService = new PlanetCrudService(entityManager);

    }


    @Test
    public void testPlanetCrudOperations() {
        Planet planet = new Planet();
        planet.setId("EARTH");
        planet.setName("Earth");


        planet = planetCrudService.save(planet);
        Optional<Planet> fetchedPlanet = planetCrudService.getById("EARTH");
        Assertions.assertTrue(fetchedPlanet.isPresent());
        Assertions.assertEquals("Earth", fetchedPlanet.get().getName());


        planetCrudService.deleteById("EARTH");
        fetchedPlanet = planetCrudService.getById("EARTH");
        Assertions.assertFalse(fetchedPlanet.isPresent());
    }
}

