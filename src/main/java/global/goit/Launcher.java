package global.goit;

import global.goit.entities.Client;
import global.goit.entities.Planet;
import global.goit.services.ClientCrudService;
import global.goit.services.PlanetCrudService;
import global.goit.utils.HibernateUtil;

import global.goit.utils.MigrationUtils;

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

        planetService.createPlanet(new Planet("BMW55", "BMW"));
        System.out.println(planetService.readPlanet("VENERA88"));
        planetService.updatePlanet("BMW55", "BMW7");
        planetService.deletePlanet("JUPITER17");
        planetService.getAllPlanets().forEach(System.out::println);

        HibernateUtil.getInstance().close();
    }
}

