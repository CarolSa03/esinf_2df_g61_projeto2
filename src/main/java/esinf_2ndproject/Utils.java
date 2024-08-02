package esinf_2ndproject;

public class Utils {

    private static final double earthRadius = 6371.0;

    public static double calculateDistance(double firstLatitude, double firstLongitude, double lastLatitude, double lastLongitude) {

        double dLat = Math.toRadians(lastLatitude - firstLatitude);
        double dLon = Math.toRadians(lastLongitude - firstLongitude);

        firstLatitude = Math.toRadians(firstLatitude);
        lastLatitude = Math.toRadians(lastLatitude);

        double a = Math.pow(Math.sin(dLat / 2), 2) + Math.pow(Math.sin(dLon / 2), 2) * Math.cos(firstLatitude) * Math.cos(lastLatitude);
        double rad = 6371;
        double c = 2 * Math.asin(Math.sqrt(a));
        return rad * c;

    }

    public static Double calculateArea(double distance) {

        return 2 * Math.PI * (earthRadius * earthRadius) * (1 - Math.cos(distance / (2 * earthRadius)));

    }

}
