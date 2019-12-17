package javasound.peoplefinder.entity;

import org.jvnet.hk2.internal.Collector;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public enum Locations {

    LONDON(new Place("London", 51.4999289,-0.1333594)),
    LEEDS(new Place("Leeds", 53.7981361,-1.5326622));

    private final Place place;

    Locations(Place place) {
        this.place = place;
    }

    public double latitude() {
        return place.getLatitude();
    }

    public double longitude() {
        return place.getLongitude();
    }

    public static Locations getPlace(String placeName) {

        List<Locations> places = Arrays.asList(Locations.values()).stream()
                .filter(location -> location.place.getName().equalsIgnoreCase(placeName))
                .collect(Collectors.toList());

        return places.isEmpty() ? null : places.get(0);
    }

}
