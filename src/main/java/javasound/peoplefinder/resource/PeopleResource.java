package javasound.peoplefinder.resource;

import javasound.peoplefinder.entity.Locations;
import javasound.peoplefinder.entity.Person;
import javasound.peoplefinder.entity.Place;
import javasound.peoplefinder.service.PeopleService;
import org.slf4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class PeopleResource {

    private final PeopleService peopleService;
    private final Logger LOGGER;

    public PeopleResource(PeopleService peopleService, Logger logger) {
        this.peopleService = peopleService;
        LOGGER = logger;
    }

    @GET
    @Path("/people/{city}")
    public Response getPeopleInCity(@PathParam("city") String city) {

        Locations place = Locations.getPlace(city);
        if(place == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(city + " is not recognised as a city")
                    .build();
        }

        try {
            List<Person> people = peopleService.find(place);
            return Response.status(Response.Status.OK).entity(people).build();
        }
        catch(Exception e) {
            LOGGER.error("Error when finding people", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
