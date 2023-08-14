package global.goit;

import global.goit.entities.Client;
import global.goit.entities.Planet;
import global.goit.services.ClientCrudService;
import global.goit.services.PlanetCrudService;
import global.goit.utils.HibernateUtil;

import global.goit.utils.MigrationUtil;

public class Launcher {

    public static void main(String[] args) {

        MigrationUtil.checkMigration();

        ClientCrudService clientService = new ClientCrudService();

        clientService.createClient(new Client("Olga"));
        System.out.println(clientService.readClient(6L));
        clientService.updateClient(5, "Viktor");
        clientService.deleteClient(2);
        clientService.getAllClients().forEach(System.out::println);

        PlanetCrudService planetService = new PlanetCrudService();

        planetService.createPlanet(new Planet("VENUS2", "ASADA"));
        System.out.println(planetService.readPlanet("JUP7"));
        planetService.updatePlanet("VENUS2", "ASAP6");
        planetService.deletePlanet("MARS");
        planetService.getAllPlanets().forEach(System.out::println);

        HibernateUtil.getInstance().close();
    }
}

