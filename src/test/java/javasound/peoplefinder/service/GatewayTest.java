package javasound.peoplefinder.service;

import javasound.peoplefinder.exception.ApplicationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javasound.peoplefinder.service.Gateway.ERROR_WHEN_ACCESSING_REMOTE_SERVICE;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GatewayTest {

    public static final String SOME_JSON = "someJson";
    public static final String SOME_URL = "someUrl";
    private Gateway gateway;
    private Client client = mock(Client.class);
    private WebTarget webTarget = mock(WebTarget.class);
    private Invocation.Builder builder = mock(Invocation.Builder.class);
    private Response response = mock(Response.class);

    @BeforeEach
    public void setUp() {
        gateway = new Gateway(client);

        when(client.target(anyString())).thenReturn(webTarget);
        when(webTarget.request(Mockito.any(MediaType.class))).thenReturn(builder);
        when(builder.get()).thenReturn(response);
    }

    @Test
    public void shouldGetJson() {

        when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
        when(response.readEntity(byte[].class)).thenReturn(SOME_JSON.getBytes());

        String json = gateway.getJson(SOME_URL);
        assertThat(json).isEqualTo(SOME_JSON);
    }

    @DisplayName("If the service doesnt return 200 throw an error")
    @Test
    public void shouldThrowErrorWhenNot200() {

        when(response.getStatus()).thenReturn(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());

        Throwable thrown = assertThrows(ApplicationException.class,
                () -> gateway.getJson(SOME_URL));

        assertThat(thrown.getMessage()).isEqualTo(ERROR_WHEN_ACCESSING_REMOTE_SERVICE);
    }
}