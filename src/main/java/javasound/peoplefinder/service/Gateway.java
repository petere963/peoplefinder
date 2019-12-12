package javasound.peoplefinder.service;

import javasound.peoplefinder.exception.ApplicationException;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class Gateway {

    public static final String ERROR_WHEN_ACCESSING_REMOTE_SERVICE = "Error when accessing remote service";
    private final Client client;

    public Gateway(Client client) {
        this.client = client;
    }

    public String getJson(String url) {



        Response response = client.target(url).request(new MediaType[]{MediaType.APPLICATION_JSON_TYPE}).get();
        if(response.getStatus() != Response.Status.OK.getStatusCode()) {
            throw new ApplicationException(ERROR_WHEN_ACCESSING_REMOTE_SERVICE);
        }

        return new String((byte[])response.readEntity(byte[].class));
    }
}
