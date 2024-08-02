package esinf_2ndproject;

/**
 * The type Exercise one.
 */
public class ExerciseOne {

    /**
     * Gets vehicle by id.
     *
     * @param vehId      the veh id
     * @param vehicleAVL the vehicle avl
     * @return the vehicle by id
     */
    public static Vehicle getVehicleById(int vehId, AVL<Vehicle> vehicleAVL) {
        Vehicle vehicle = new Vehicle(vehId);

        if (vehicleAVL.find(vehicle) == null) return null;

        else return vehicleAVL.find(vehicle).getElement();
    }

    /**
     * Gets trip by id.
     *
     * @param tripId  the trip id
     * @param tripAVL the trip avl
     * @return the trip by id
     */
    public static Trip getTripById(int tripId, AVL<Trip> tripAVL) {
        Trip trip = new Trip(tripId);

        if (tripAVL.find(trip) == null) return null;

        else return tripAVL.find(trip).getElement();
    }

}