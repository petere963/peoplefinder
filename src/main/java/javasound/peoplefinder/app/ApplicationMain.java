package javasound.peoplefinder.app;


import io.dropwizard.Application;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.setup.Environment;
import javasound.peoplefinder.service.DistanceCalculator;
import javasound.peoplefinder.service.Gateway;
import javasound.peoplefinder.service.PeopleService;
import javasound.peoplefinder.resource.PeopleResource;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.Client;


public class ApplicationMain extends Application<ApplicationConfiguration> {

    public static void main(String[] args) throws Exception {
        new ApplicationMain().run(args);
    }

    @Override
    public void run(ApplicationConfiguration config, Environment environment) throws Exception {

        Client client = new JerseyClientBuilder(environment)
                .using(config.getJerseyClientConfiguration())
                .build(getName());

        registerResources(config, environment, client);
    }


    public void registerResources(ApplicationConfiguration config, Environment environment, Client client) {

        Gateway gateway = new Gateway(client);
        PeopleService peopleService = new PeopleService(config, new DistanceCalculator(), gateway);

        environment.jersey().register(new PeopleResource(peopleService,LoggerFactory.getLogger(PeopleResource.class)));
    }
}
