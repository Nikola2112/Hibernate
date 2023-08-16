import entities.Client;
import entities.Planet;
import services.ClientCrudService;
import services.PlanetCrudService;
import utils.HibernateUtil;

import utils.MigrationUtils;

public class Launcher {

    public static void main(String[] args) {

        MigrationUtils.checkMigration();

        ClientCrudService clientService = new ClientCrudService();

        clientService.createClient(new Client("Olga"));
        System.out.println(clientService.readClient(6L));
        clientService.updateClient(5, "Viktor");
        clientService.deleteClient(2);
        clientService.getAllClients().forEach(System.out::println);

        PlanetCrudService planetService = new PlanetCrudService();

        planetService.createPlanet(new Planet("VENUS2", "VENUS"));
        System.out.println(planetService.readPlanet("JSAT2"));
        planetService.updatePlanet("VENUS2", "VENUS6");
        planetService.deletePlanet("MARS");
        planetService.getAllPlanets().forEach(System.out::println);

        HibernateUtil.getInstance().close();
    }
}

