package javasound.peoplefinder.entity;

public class Place {

    private final String name;
    private double latitude;
    private double longitude;

    public Place(String name, double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getName() {
        return name;
    }
}
