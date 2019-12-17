package javasound.peoplefinder.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlaceTest {

    public static final double LATITUDE = -1.234;
    public static final double LONGITUDE = 5.678;
    public static final String SOME_NAME = "someName";

    @Test
    public void shouldConstruct() {

        Place place = new Place(SOME_NAME, LATITUDE, LONGITUDE);
        assertThat(place.getLatitude()).isEqualTo(LATITUDE);
        assertThat(place.getLongitude()).isEqualTo(LONGITUDE);
        assertThat(place.getName()).isEqualTo(SOME_NAME);
    }

    @Test
    public void shouldFindPlaceByName() {

        assertThat(Locations.getPlace("leeds")).isEqualTo(Locations.LEEDS);
        assertThat(Locations.getPlace("Leeds")).isEqualTo(Locations.LEEDS);
        assertThat(Locations.getPlace("somePLace")).isNull();
    }
}