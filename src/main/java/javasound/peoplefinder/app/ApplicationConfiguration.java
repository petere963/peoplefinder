package javasound.peoplefinder.app;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.client.JerseyClientConfiguration;

public class ApplicationConfiguration extends Configuration {

    @JsonProperty("jerseyHttpClient")
    private JerseyClientConfiguration jerseyClientConfiguration;

    @JsonProperty("herukoUrl")
    private String herukoUrl;

    @JsonProperty("searchRadius")
    private int searchRadius;

    public JerseyClientConfiguration getJerseyClientConfiguration() {
        return jerseyClientConfiguration;
    }

    public String getHerukoUrl() {
        return herukoUrl;
    }

    public int getSearchRadius() {
        return searchRadius;
    }
}
