package javasound.peoplefinder.service;

import java.lang.*;

public class DistanceCalculator {

    public int distanceMiles(Double lat1, Double lon1, Double lat2, Double lon2) {
        if ((lat1 == lat2) && (lon1 == lon2)) {
            return 0;
        }

        double theta = lon1 - lon2;
        double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
        dist = Math.acos(dist);
        dist = Math.toDegrees(dist);
        dist = dist * 60 * 1.1515;

        return (int) Math.round(dist);
    }
}
