package javasound.peoplefinder.entity;

public enum Locations {

    LONDON(new Place(51.4999289,-0.1333594)),
    LEEDS(new Place(53.7981361,-1.5326622));

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



}
