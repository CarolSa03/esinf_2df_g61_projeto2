package esinf_2ndproject;

/**
 * The type Vehicle.
 */
public class Vehicle implements Comparable<Vehicle> {
    private int vehicleId;
    private VehicleType vehicleType;
    private String vehicleClass;
    private String engine;
    private String transmission;
    private String driveWheels;
    private String weight;
    private AVL<Trip> tripAVL;

    /**
     * Instantiates a new Vehicle.
     *
     * @param vehicleId    the vehicle id
     * @param vehicleType  the vehicle type
     * @param vehicleClass the vehicle class
     * @param engine       the engine
     * @param transmission the transmission
     * @param driveWheels  the drive wheels
     * @param weight       the weight
     * @param tripAVL      the trip avl
     */
    public Vehicle(int vehicleId, VehicleType vehicleType, String vehicleClass, String engine, String transmission, String driveWheels, String weight, AVL<Trip> tripAVL) {
        setVehicleId(vehicleId);
        setVehicleType(vehicleType);
        setVehicleClass(vehicleClass);
        setEngine(engine);
        setTransmission(transmission);
        setDriveWheels(driveWheels);
        setWeight(weight);
        setTripAVL(tripAVL);
    }

    /**
     * Instantiates a new Vehicle.
     *
     * @param vehicleId the vehicle id
     */
    public Vehicle(int vehicleId) {
        setVehicleId(vehicleId);
        setTripAVL(new AVL<>());
    }

    /**
     * Instantiates a new Vehicle.
     */
    public Vehicle() {
        setTripAVL(new AVL<>());
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
     * Gets vehicle type.
     *
     * @return the vehicle type
     */
    public VehicleType getVehicleType() {
        return vehicleType;
    }

    /**
     * Sets vehicle type.
     *
     * @param vehicleType the vehicle type
     */
    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    /**
     * Gets vehicle class.
     *
     * @return the vehicle class
     */
    public String getVehicleClass() {
        return vehicleClass;
    }

    /**
     * Sets vehicle class.
     *
     * @param vehicleClass the vehicle class
     */
    public void setVehicleClass(String vehicleClass) {
        this.vehicleClass = vehicleClass;
    }

    /**
     * Gets engine.
     *
     * @return the engine
     */
    public String getEngine() {
        return engine;
    }

    /**
     * Sets engine.
     *
     * @param engine the engine
     */
    public void setEngine(String engine) {
        this.engine = engine;
    }

    /**
     * Gets transmission.
     *
     * @return the transmission
     */
    public String getTransmission() {
        return transmission;
    }

    /**
     * Sets transmission.
     *
     * @param transmission the transmission
     */
    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    /**
     * Gets drive wheels.
     *
     * @return the drive wheels
     */
    public String getDriveWheels() {
        return driveWheels;
    }

    /**
     * Sets drive wheels.
     *
     * @param driveWheels the drive wheels
     */
    public void setDriveWheels(String driveWheels) {
        this.driveWheels = driveWheels;
    }

    /**
     * Gets weight.
     *
     * @return the weight
     */
    public String getWeight() {
        return weight;
    }

    /**
     * Sets weight.
     *
     * @param weight the weight
     */
    public void setWeight(String weight) {
        this.weight = weight;
    }

    /**
     * Gets trip avl.
     *
     * @return the trip avl
     */
    public AVL<Trip> getTripAVL() {
        return tripAVL;
    }

    /**
     * Sets trip avl.
     *
     * @param tripAVL the trip avl
     */
    public void setTripAVL(AVL<Trip> tripAVL) {
        this.tripAVL = tripAVL;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", vehicleType=" + vehicleType +
                ", vehicleClass='" + vehicleClass + '\'' +
                ", engine='" + engine + '\'' +
                ", transmission='" + transmission + '\'' +
                ", driveWheels='" + driveWheels + '\'' +
                ", weight='" + weight + '\'' +
                ", tripAVL=\n" + tripAVL +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj instanceof Vehicle vehicle) {
            return this.vehicleId == vehicle.vehicleId;
        }
        return false;
    }

    @Override
    public int compareTo(Vehicle o) {
        return Integer.compare(this.vehicleId, o.vehicleId);
    }

}
