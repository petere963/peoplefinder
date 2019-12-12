package javasound.peoplefinder.service;

import javasound.peoplefinder.app.ApplicationConfiguration;
import javasound.peoplefinder.entity.Locations;
import javasound.peoplefinder.entity.Person;

import java.util.List;
import java.util.stream.Collectors;

public class PeopleService {

     private final ApplicationConfiguration configuration;
    private final String usersUrl;
    private final JsonMapper jsonMapper;
    private final DistanceCalculator distanceCalculator;
    private final Gateway gateway;

    public PeopleService(ApplicationConfiguration configuration, DistanceCalculator distanceCalculator, Gateway gateway) {
        this.configuration = configuration;
        usersUrl = configuration.getHerukoUrl() + "users";
        this.distanceCalculator = distanceCalculator;
        this.gateway = gateway;
        jsonMapper = new JsonMapper();
    }

    public List<Person> find(Locations location) {

        String json = gateway.getJson(usersUrl);
        List<Person> people = jsonMapper.getPeople(json);

        return people.stream()
                .filter(person -> isInRange(person, location))
                .collect(Collectors.toList());
    }

    private boolean isInRange(Person person, Locations location) {

        int distance = distanceCalculator.distanceMiles(
                location.latitude(),
                location.longitude(),
                person.getLatitude(),
                person.getLongitude());

        return distance <= configuration.getSearchRadius();
    }
}
