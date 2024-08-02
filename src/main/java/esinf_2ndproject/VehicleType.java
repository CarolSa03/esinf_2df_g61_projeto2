package esinf_2ndproject;

/**
 * The enum Vehicle type.
 */
public enum VehicleType {

    /**
     * Ice vehicle type.
     */
    ICE("ICE"),
    /**
     * Hev vehicle type.
     */
    HEV("HEV"),
    /**
     * Phev vehicle type.
     */
    PHEV("PHEV"),
    /**
     * Ev vehicle type.
     */
    EV("EV");

    private String vehicleType;

    VehicleType(String vehicleType) {
        setVehicleType(vehicleType);
    }

    /**
     * Gets vehicle type.
     *
     * @return the vehicle type
     */
    public String getVehicleType() {
        return vehicleType;
    }

    /**
     * Sets vehicle type.
     *
     * @param vehicleType the vehicle type
     */
    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

}