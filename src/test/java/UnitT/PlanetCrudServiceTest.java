package UnitT;

import entities.Planet;
import services.PlanetCrudService;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class PlanetCrudServiceTest {

    private SessionFactory sessionFactory;
    private PlanetCrudService planetCrudService;

    @Before
    public void setup() {
        sessionFactory = new Configuration()
                .configure("hibernate.properties")
                .addAnnotatedClass(Planet.class)
                .buildSessionFactory();

        planetCrudService = new PlanetCrudService(sessionFactory);
    }

    @After
    public void tearDown() {
        sessionFactory.close();
    }

    @Test
    public void testSaveAndGetById() {
        Planet planet = new Planet();
        planet.setId("MARS");
        planet.setName("Mars");

        Planet savedPlanet = planetCrudService.save(planet);
        assertNotNull(savedPlanet.getId());

        Optional<Planet> fetchedPlanet = planetCrudService.getById(savedPlanet.getId());
        assertTrue(fetchedPlanet.isPresent());
        assertEquals("MARS", fetchedPlanet.get().getId());
        assertEquals("Mars", fetchedPlanet.get().getName());
    }

    @Test
    public void testDelete() {
        Planet planet = new Planet();
        planet.setId("VEN");
        planet.setName("Venus");

        Planet savedPlanet = planetCrudService.save(planet);

        planetCrudService.deleteById(savedPlanet.getId());

        Optional<Planet> deletedPlanet = planetCrudService.getById(savedPlanet.getId());
        assertFalse(deletedPlanet.isPresent());
    }

    @Test
    public void testGetAllPlanets() {
        List<Planet> planets = planetCrudService.getAll();
        assertNotNull(planets);
        int initialSize = planets.size();

        Planet planet1 = new Planet();
        planet1.setId("EARTH");
        planet1.setName("Earth");

        Planet planet2 = new Planet();
        planet2.setId("JUP");
        planet2.setName("Jupiter");

        planetCrudService.save(planet1);
        planetCrudService.save(planet2);

        planets = planetCrudService.getAll();
        assertEquals(initialSize + 2, planets.size());
    }

    @Test
    public void testUpdate() {
        Planet planet = new Planet();
        planet.setId("SAT");
        planet.setName("Saturn");

        Planet savedPlanet = planetCrudService.save(planet);

        savedPlanet.setName("Updated Planet");
        planetCrudService.update(savedPlanet);

        Optional<Planet> updatedPlanet = planetCrudService.getById(savedPlanet.getId());
        assertTrue(updatedPlanet.isPresent());
        assertEquals("Updated Planet", updatedPlanet.get().getName());
    }
}
