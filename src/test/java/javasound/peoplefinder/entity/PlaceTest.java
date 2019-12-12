package javasound.peoplefinder.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlaceTest {

    public static final double LATITUDE = -1.234;
    public static final double LONGITUDE = 5.678;

    @Test
    public void shouldConstruct() {

        Place place = new Place(LATITUDE, LONGITUDE);
        assertThat(place.getLatitude()).isEqualTo(LATITUDE);
        assertThat(place.getLongitude()).isEqualTo(LONGITUDE);
    }
}