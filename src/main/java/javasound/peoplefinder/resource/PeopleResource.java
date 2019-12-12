package javasound.peoplefinder.resource;

import javasound.peoplefinder.entity.Locations;
import javasound.peoplefinder.entity.Person;
import javasound.peoplefinder.service.PeopleService;
import org.slf4j.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
    @Path("/people/london")
    public Response getPeopleInLondon() {

        try {
            List<Person> people = peopleService.find(Locations.LONDON);
            return Response.status(Response.Status.OK).entity(people).build();
        }
        catch(Exception e) {
            LOGGER.error("Error when finding people", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
