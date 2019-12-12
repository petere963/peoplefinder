package javasound.peoplefinder.app;

import io.dropwizard.jersey.setup.JerseyEnvironment;
import io.dropwizard.setup.Environment;
import javasound.peoplefinder.resource.PeopleResource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.ws.rs.client.Client;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ApplicationMainTest {

    private Environment environment = mock(Environment.class);
    private JerseyEnvironment jersey = mock(JerseyEnvironment.class);
    private Client client = mock(Client.class);
    private ApplicationConfiguration config = mock(ApplicationConfiguration.class);

    @DisplayName("Resister resources when application starts")
    @Test
    public void shouldRegisterResources() throws Exception {

        when(environment.jersey()).thenReturn(jersey);
        new ApplicationMain().registerResources(config, environment, client);
        verify(jersey).register(any(PeopleResource.class));
    }
}