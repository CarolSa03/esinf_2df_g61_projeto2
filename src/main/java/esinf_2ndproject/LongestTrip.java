package esinf_2ndproject;

public class LongestTrip {
    private int vehId;
    private Trip trip;
    private double distance;

    public LongestTrip(int vehId, Trip trip, double distance) {
        this.vehId = vehId;
        this.trip = trip;
        this.distance = distance;
    }

    public int getVehId() {
        return vehId;
    }

    public Trip getTrip() {
        return trip;
    }

    public double getDistance() {
        return distance;
    }
}
