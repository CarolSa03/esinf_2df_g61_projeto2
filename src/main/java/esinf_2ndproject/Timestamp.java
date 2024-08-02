package esinf_2ndproject;

/**
 * The type Timestamp.
 */
public class Timestamp implements Comparable<Timestamp> {

    private int timestamp;
    private double latitude;
    private double longitude;
    private double vehicleSpeed;
    private String maf;
    private String engineRPM;
    private String absoluteLoad;
    private String oat;
    private String fuelRate;
    private String airConditioningPowerKW;
    private String airConditioningPowerW;
    private String heaterPower;
    private String hvBatteryCurrent;
    private String hvBatterySOC;
    private String hvBatteryVoltage;
    private String shortTermFuelTrimBank1;
    private String shortTermFuelTrimBank2;
    private String longTermFuelTrimBank1;
    private String longTermFuelTrimBank2;

    /**
     * Instantiates a new Timestamp.
     *
     * @param timestamp              the timestamp
     * @param latitude               the latitude
     * @param longitude              the longitude
     * @param vehicleSpeed           the vehicle speed
     * @param maf                    the maf
     * @param engineRPM              the engine rpm
     * @param absoluteLoad           the absolute load
     * @param oat                    the oat
     * @param fuelRate               the fuel rate
     * @param airConditioningPowerKW the air conditioning power kw
     * @param airConditioningPowerW  the air conditioning power w
     * @param heaterPower            the heater power
     * @param hvBatteryCurrent       the hv battery current
     * @param hvBatterySOC           the hv battery soc
     * @param hvBatteryVoltage       the hv battery voltage
     * @param shortTermFuelTrimBank1 the short term fuel trim bank 1
     * @param shortTermFuelTrimBank2 the short term fuel trim bank 2
     * @param longTermFuelTrimBank1  the long term fuel trim bank 1
     * @param longTermFuelTrimBank2  the long term fuel trim bank 2
     */
    public Timestamp(int timestamp, double latitude, double longitude, double vehicleSpeed, String maf, String engineRPM, String absoluteLoad, String oat, String fuelRate, String airConditioningPowerKW, String airConditioningPowerW, String heaterPower, String hvBatteryCurrent, String hvBatterySOC, String hvBatteryVoltage, String shortTermFuelTrimBank1, String shortTermFuelTrimBank2, String longTermFuelTrimBank1, String longTermFuelTrimBank2) {
        setTimestamp(timestamp);
        setLatitude(latitude);
        setLongitude(longitude);
        setVehicleSpeed(vehicleSpeed);
        setMaf(maf);
        setEngineRPM(engineRPM);
        setAbsoluteLoad(absoluteLoad);
        setOat(oat);
        setFuelRate(fuelRate);
        setAirConditioningPowerKW(airConditioningPowerKW);
        setAirConditioningPowerW(airConditioningPowerW);
        setHeaterPower(heaterPower);
        setHvBatteryCurrent(hvBatteryCurrent);
        setHvBatterySOC(hvBatterySOC);
        setHvBatteryVoltage(hvBatteryVoltage);
        setShortTermFuelTrimBank1(shortTermFuelTrimBank1);
        setShortTermFuelTrimBank2(shortTermFuelTrimBank2);
        setLongTermFuelTrimBank1(longTermFuelTrimBank1);
        setLongTermFuelTrimBank2(longTermFuelTrimBank2);
    }

    /**
     * Instantiates a new Timestamp.
     */
    public Timestamp() {
    }

    /**
     * Gets absolute load.
     *
     * @return the absolute load
     */
    public String getAbsoluteLoad() {
        return absoluteLoad;
    }

    /**
     * Sets absolute load.
     *
     * @param absoluteLoad the absolute load
     */
    public void setAbsoluteLoad(String absoluteLoad) {
        this.absoluteLoad = absoluteLoad;
    }

    /**
     * Gets air conditioning power kw.
     *
     * @return the air conditioning power kw
     */
    public String getAirConditioningPowerKW() {
        return airConditioningPowerKW;
    }

    /**
     * Sets air conditioning power kw.
     *
     * @param airConditioningPowerKW the air conditioning power kw
     */
    public void setAirConditioningPowerKW(String airConditioningPowerKW) {
        this.airConditioningPowerKW = airConditioningPowerKW;
    }

    /**
     * Gets air conditioning power w.
     *
     * @return the air conditioning power w
     */
    public String getAirConditioningPowerW() {
        return airConditioningPowerW;
    }

    /**
     * Sets air conditioning power w.
     *
     * @param airConditioningPowerW the air conditioning power w
     */
    public void setAirConditioningPowerW(String airConditioningPowerW) {
        this.airConditioningPowerW = airConditioningPowerW;
    }

    /**
     * Gets engine rpm.
     *
     * @return the engine rpm
     */
    public String getEngineRPM() {
        return engineRPM;
    }

    /**
     * Sets engine rpm.
     *
     * @param engineRPM the engine rpm
     */
    public void setEngineRPM(String engineRPM) {
        this.engineRPM = engineRPM;
    }

    /**
     * Gets fuel rate.
     *
     * @return the fuel rate
     */
    public String getFuelRate() {
        return fuelRate;
    }

    /**
     * Sets fuel rate.
     *
     * @param fuelRate the fuel rate
     */
    public void setFuelRate(String fuelRate) {
        this.fuelRate = fuelRate;
    }

    /**
     * Gets heater power.
     *
     * @return the heater power
     */
    public String getHeaterPower() {
        return heaterPower;
    }

    /**
     * Sets heater power.
     *
     * @param heaterPower the heater power
     */
    public void setHeaterPower(String heaterPower) {
        this.heaterPower = heaterPower;
    }

    /**
     * Gets hv battery current.
     *
     * @return the hv battery current
     */
    public String getHvBatteryCurrent() {
        return hvBatteryCurrent;
    }

    /**
     * Sets hv battery current.
     *
     * @param hvBatteryCurrent the hv battery current
     */
    public void setHvBatteryCurrent(String hvBatteryCurrent) {
        this.hvBatteryCurrent = hvBatteryCurrent;
    }

    /**
     * Gets hv battery soc.
     *
     * @return the hv battery soc
     */
    public String getHvBatterySOC() {
        return hvBatterySOC;
    }

    /**
     * Sets hv battery soc.
     *
     * @param hvBatterySOC the hv battery soc
     */
    public void setHvBatterySOC(String hvBatterySOC) {
        this.hvBatterySOC = hvBatterySOC;
    }

    /**
     * Gets hv battery voltage.
     *
     * @return the hv battery voltage
     */
    public String getHvBatteryVoltage() {
        return hvBatteryVoltage;
    }

    /**
     * Sets hv battery voltage.
     *
     * @param hvBatteryVoltage the hv battery voltage
     */
    public void setHvBatteryVoltage(String hvBatteryVoltage) {
        this.hvBatteryVoltage = hvBatteryVoltage;
    }

    /**
     * Gets latitude.
     *
     * @return the latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Sets latitude.
     *
     * @param latitude the latitude
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * Gets longitude.
     *
     * @return the longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Sets longitude.
     *
     * @param longitude the longitude
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * Gets long term fuel trim bank 1.
     *
     * @return the long term fuel trim bank 1
     */
    public String getLongTermFuelTrimBank1() {
        return longTermFuelTrimBank1;
    }

    /**
     * Sets long term fuel trim bank 1.
     *
     * @param longTermFuelTrimBank1 the long term fuel trim bank 1
     */
    public void setLongTermFuelTrimBank1(String longTermFuelTrimBank1) {
        this.longTermFuelTrimBank1 = longTermFuelTrimBank1;
    }

    /**
     * Gets long term fuel trim bank 2.
     *
     * @return the long term fuel trim bank 2
     */
    public String getLongTermFuelTrimBank2() {
        return longTermFuelTrimBank2;
    }

    /**
     * Sets long term fuel trim bank 2.
     *
     * @param longTermFuelTrimBank2 the long term fuel trim bank 2
     */
    public void setLongTermFuelTrimBank2(String longTermFuelTrimBank2) {
        this.longTermFuelTrimBank2 = longTermFuelTrimBank2;
    }

    /**
     * Gets maf.
     *
     * @return the maf
     */
    public String getMaf() {
        return maf;
    }

    /**
     * Sets maf.
     *
     * @param maf the maf
     */
    public void setMaf(String maf) {
        this.maf = maf;
    }

    /**
     * Gets oat.
     *
     * @return the oat
     */
    public String getOat() {
        return oat;
    }

    /**
     * Sets oat.
     *
     * @param oat the oat
     */
    public void setOat(String oat) {
        this.oat = oat;
    }

    /**
     * Gets short term fuel trim bank 1.
     *
     * @return the short term fuel trim bank 1
     */
    public String getShortTermFuelTrimBank1() {
        return shortTermFuelTrimBank1;
    }

    /**
     * Sets short term fuel trim bank 1.
     *
     * @param shortTermFuelTrimBank1 the short term fuel trim bank 1
     */
    public void setShortTermFuelTrimBank1(String shortTermFuelTrimBank1) {
        this.shortTermFuelTrimBank1 = shortTermFuelTrimBank1;
    }

    /**
     * Gets short term fuel trim bank 2.
     *
     * @return the short term fuel trim bank 2
     */
    public String getShortTermFuelTrimBank2() {
        return shortTermFuelTrimBank2;
    }

    /**
     * Sets short term fuel trim bank 2.
     *
     * @param shortTermFuelTrimBank2 the short term fuel trim bank 2
     */
    public void setShortTermFuelTrimBank2(String shortTermFuelTrimBank2) {
        this.shortTermFuelTrimBank2 = shortTermFuelTrimBank2;
    }

    /**
     * Gets timestamp.
     *
     * @return the timestamp
     */
    public int getTimestamp() {
        return timestamp;
    }

    /**
     * Sets timestamp.
     *
     * @param timestamp the timestamp
     */
    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Gets vehicle speed.
     *
     * @return the vehicle speed
     */
    public double getVehicleSpeed() {
        return vehicleSpeed;
    }

    /**
     * Sets vehicle speed.
     *
     * @param vehicleSpeed the vehicle speed
     */
    public void setVehicleSpeed(double vehicleSpeed) {
        this.vehicleSpeed = vehicleSpeed;
    }

    @Override
    public String toString() {
        return "Timestamp{" +
                "timestamp=" + timestamp +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", vehicleSpeed=" + vehicleSpeed +
                ", maf=" + maf +
                ", engineRPM=" + engineRPM +
                ", absoluteLoad=" + absoluteLoad +
                ", oat=" + oat +
                '}';
    }

    @Override
    public int compareTo(Timestamp o) {
        return Integer.compare(this.timestamp, o.timestamp);
    }

}