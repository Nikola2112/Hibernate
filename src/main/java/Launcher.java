import entities.Client;
import entities.Planet;
import services.ClientCrudService;
import services.PlanetCrudService;
import utils.HibernateUtil;
import utils.MigrationUtil;

public class Launcher {

    public static void main(String[] args) {

        MigrationUtil.checkMigration();


        HibernateUtil hibernateUtil = HibernateUtil.getInstance();

        ClientCrudService clientCrudService = new ClientCrudService(hibernateUtil.getSessionFactory());


        PlanetCrudService planetCrudService = new PlanetCrudService(hibernateUtil.getSessionFactory());


        Client client = new Client();
        client.setId(1);
        client.setName("John Doe");

        clientCrudService.save(client);

        System.out.println("Saved client: " + client.getName());

        clientCrudService.getById(1L);


        Planet planet = new Planet();
        planet.setId("earth");
        planet.setName("Earth");

        planetCrudService.save(planet);

        System.out.println("Saved planet: " + planet.getName());

        planetCrudService.getById("earth");


        hibernateUtil.close();
    }
}
