package esinf_2ndproject;

import java.io.*;

/**
 * The type Read file.
 */
public class ReadFile {
    private static final File fileWeek = new File("VEData/VED_180404_week.csv");
    private static final File fileDataIceHev = new File("VEData/VED_Static_Data_ICE&HEV.csv");
    private static final File fileDataPhevEv = new File("VEData/VED_Static_Data_PHEV&EV.csv");
    private static final File fileWeekCopy = new File("VEData/VED_180404_week_copy.csv");
    private static final File fileDataIceHevCopy = new File("VEData/VED_Static_Data_ICE&HEV_copy.csv");
    private static final File fileDataPhevEvCopy = new File("VEData/VED_Static_Data_PHEV&EV_copy.csv");
    private static final AVL<Vehicle> vehicleAVL = new AVL<>();
    private static final AVL<Trip> tripAVL = new AVL<>();

    /**
     * Gets vehicle avl.
     *
     * @return the vehicle avl
     */
    public static AVL<Vehicle> getVehicleAVL() {
        return vehicleAVL;
    }

    /**
     * Gets trip avl.
     *
     * @return the trip avl
     */
    public static AVL<Trip> getTripAVL() {
        return tripAVL;
    }

    /**
     * Read files.
     *
     * @throws IOException the io exception
     */
    public static void readFiles() throws IOException {
        readFileDataIceHev();
        readFileDataPhevEv();
        readFileWeek(new FileReader(fileWeek));
    }

    public static void readCopyFiles() throws IOException {
        readFileDataIceHevCopy();
        readFileDataPhevEvCopy();
        readFileWeek(new FileReader(fileWeekCopy));
    }

    private static void readFileDataIceHevCopy() throws IOException {
        FileReader fileReader = new FileReader(fileDataIceHevCopy);
        readFileData(fileReader);
    }

    private static void readFileDataPhevEvCopy() throws IOException {
        FileReader fileReader = new FileReader(fileDataPhevEvCopy);
        readFileData(fileReader);
    }

    private static void readFileDataPhevEv() throws IOException {
        FileReader fileReader = new FileReader(fileDataPhevEv);
        readFileData(fileReader);
    }

    private static void readFileDataIceHev() throws IOException {
        FileReader fileReader = new FileReader(fileDataIceHev);
        readFileData(fileReader);
    }

    public static void readFileData(FileReader fileReader) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        //skip first line
        bufferedReader.readLine();
        String line = bufferedReader.readLine();

        do {

            String[] data = line.split(",");

            Vehicle vehicle = new Vehicle();

            vehicle.setVehicleId(Integer.parseInt(data[0]));
            vehicle.setVehicleType(VehicleType.valueOf(data[1].toUpperCase()));
            vehicle.setVehicleClass(data[2]);
            vehicle.setEngine(data[3]);
            vehicle.setTransmission(data[4]);
            vehicle.setDriveWheels(data[5]);
            vehicle.setWeight(data[6]);

            vehicleAVL.insert(vehicle);

            line = bufferedReader.readLine();

        } while (line != null);

    }

    public static void readFileWeek(FileReader fileReader) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        //skip first line
        bufferedReader.readLine();
        String line = bufferedReader.readLine();

        do {

            String[] data = line.split(",");

            int vehicleId = Integer.parseInt(data[1]);

            if (vehicleAVL.find(new Vehicle(vehicleId)) != null) {

                Vehicle vehicle = vehicleAVL.find(new Vehicle(vehicleId)).getElement();

                int tripId = Integer.parseInt(data[2]);
                Trip trip;
                if (tripAVL.find(new Trip(tripId)) != null) {
                    trip = tripAVL.find(new Trip(tripId)).getElement();
                } else {
                    trip = new Trip(tripId);
                }

                trip.setVehicleId(vehicleId);
                trip.getVehicleTripAVL().insert(vehicleId);
                while (Integer.parseInt(data[2]) == tripId) {

                    double dayNum = Double.parseDouble(data[0]);
                    Day day = new Day(dayNum);

                    while (Double.parseDouble(data[0]) == dayNum) {

                        Timestamp timestamp = new Timestamp();
                        timestamp.setTimestamp(Integer.parseInt(data[3]));
                        timestamp.setLatitude(Double.parseDouble(data[4]));
                        timestamp.setLongitude(Double.parseDouble(data[5]));
                        timestamp.setVehicleSpeed(Double.parseDouble(data[6]));
                        timestamp.setMaf(data[7]);
                        timestamp.setEngineRPM(data[8]);
                        timestamp.setAbsoluteLoad(data[9]);
                        timestamp.setOat(data[10]);
                        timestamp.setFuelRate(data[11]);
                        timestamp.setAirConditioningPowerKW(data[12]);
                        timestamp.setAirConditioningPowerW(data[13]);
                        timestamp.setHeaterPower(data[14]);
                        timestamp.setHvBatteryCurrent(data[15]);
                        timestamp.setHvBatterySOC(data[16]);
                        timestamp.setHvBatteryVoltage(data[17]);
                        timestamp.setShortTermFuelTrimBank1(data[18]);
                        timestamp.setShortTermFuelTrimBank2(data[19]);
                        timestamp.setLongTermFuelTrimBank1(data[20]);
                        timestamp.setLongTermFuelTrimBank2(data[21]);

                        day.getTimestampAVL().insert(timestamp);

                        line = bufferedReader.readLine();

                        if (line == null) break;

                        data = line.split(",");
                    }

                    trip.getDayAVL().insert(day);
                    if (line == null) break;

                }

                vehicle.getTripAVL().insert(trip);
                tripAVL.insert(trip);

            }

        } while (line != null);

    }

}