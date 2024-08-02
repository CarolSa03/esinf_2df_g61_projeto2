package esinf_2ndproject;

/**
 * The type Trip.
 */
public class Trip implements Comparable<Trip> {
    private int trip;
    private int vehicleId;
    private AVL<Day> dayAVL;
    private AVL<Integer> vehicleTripAVL;

    /**
     * Instantiates a new Trip.
     *
     * @param trip           the trip
     * @param vehicleId      the vehicle id
     * @param dayAVL         the day avl
     * @param vehicleTripAVL the vehicle trip avl
     */
    public Trip(int trip, int vehicleId, AVL<Day> dayAVL, AVL<Integer> vehicleTripAVL) {
        setTrip(trip);
        setVehicleId(vehicleId);
        setDayAVL(dayAVL);
        setVehicleTripAVL(vehicleTripAVL);
    }

    /**
     * Instantiates a new Trip.
     *
     * @param trip the trip
     */
    public Trip(int trip) {
        setTrip(trip);
        setDayAVL(new AVL<>());
        setVehicleTripAVL(new AVL<>());
    }

    /**
     * Instantiates a new Trip.
     */
    public Trip() {
        setDayAVL(new AVL<>());
        setVehicleTripAVL(new AVL<>());
    }

    /**
     * Gets trip.
     *
     * @return the trip
     */
    public int getTrip() {
        return trip;
    }

    /**
     * Sets trip.
     *
     * @param trip the trip
     */
    public void setTrip(int trip) {
        this.trip = trip;
    }

    /**
     * Gets vehicle id.
     *
     * @return the vehicle id
     */
    public int getVehicleId() {
        return vehicleId;
    }

    /**
     * Sets vehicle id.
     *
     * @param vehicleId the vehicle id
     */
    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    /**
     * Gets day avl.
     *
     * @return the day avl
     */
    public AVL<Day> getDayAVL() {
        return dayAVL;
    }

    /**
     * Sets day avl.
     *
     * @param dayAVL the day avl
     */
    public void setDayAVL(AVL<Day> dayAVL) {
        this.dayAVL = dayAVL;
    }

    /**
     * Gets vehicle trip avl.
     *
     * @return the vehicle trip avl
     */
    public AVL<Integer> getVehicleTripAVL() {
        return vehicleTripAVL;
    }

    /**
     * Sets vehicle trip avl.
     *
     * @param vehicleTripAVL the vehicle trip avl
     */
    public void setVehicleTripAVL(AVL<Integer> vehicleTripAVL) {
        this.vehicleTripAVL = vehicleTripAVL;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "trip=" + trip +
                ", vehicleId=" + vehicleId +
                ", dayAVL=\n" + dayAVL +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj instanceof Trip trip1) {
            return this.trip == trip1.trip;
        }
        return false;
    }

    @Override
    public int compareTo(Trip o) {
        if (this.trip > o.trip) return 1;
        else if (this.trip < o.trip) return -1;
        return 0;
    }
}
