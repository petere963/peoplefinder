package javasound.peoplefinder.resource;

import javasound.peoplefinder.entity.Locations;
import javasound.peoplefinder.service.PeopleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import javax.ws.rs.core.Response;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class PeopleResourceTest {

    private PeopleResource peopleResource;
    private PeopleService peopleService = mock(PeopleService.class);
    private Logger logger = mock(Logger.class);

    @BeforeEach
    public void setUp() {
        peopleResource = new PeopleResource(peopleService, logger);
    }

    @DisplayName("Execute service when find request is made")
    @Test
    public void shouldExecutePeopleServiceOnFind() {

        Response response = peopleResource.getPeopleInCity("london");
        verify(peopleService).find(any(Locations.class));
        assertThat(response.getStatus()).isEqualTo(Response.Status.OK.getStatusCode());
    }

    @DisplayName("Return Internal Server error when error in service")
    @Test
    public void shouldreturn500WhenErrorOnFind() {

        when(peopleService.find(any(Locations.class))).thenThrow(new RuntimeException("someError"));

        Response response = peopleResource.getPeopleInCity("london");
        assertThat(response.getStatus()).isEqualTo(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        verify(logger).error(Mockito.anyString(), any(Exception.class));
    }
}