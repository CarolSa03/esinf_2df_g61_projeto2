package esinf_2ndproject;

public class ExerciseTwo {

    public AVL<Double> getMinAvMaxVehicleSpeed(double dayNum1, double dayNum2, AVL<Vehicle> vehicleAVL, VehicleType vehicleTypeToMatch) {

        AVL<Double> minAvMaxVehicleSpeed = new AVL<>();

        double totalSpeed = 0;
        int counter = 0;
        double min = Integer.MAX_VALUE;
        double max = Integer.MIN_VALUE;

        for (Vehicle vehicle : vehicleAVL.inOrder()) {
            VehicleType vehicleType = ExerciseOne.getVehicleById(vehicle.getVehicleId(), vehicleAVL).getVehicleType();
            if (vehicleType != vehicleTypeToMatch) continue;
            for (Trip trip : vehicle.getTripAVL().inOrder()) {
                for (Day day : trip.getDayAVL().inOrder()) {
                    if (day.getDayNum() < dayNum1 || day.getDayNum() > dayNum2) continue;
                    for (Timestamp timestamp : day.getTimestampAVL().inOrder()) {
                        if (Double.isNaN(timestamp.getVehicleSpeed())) continue; // if speed is NaN (not a number) then skip
                        if (timestamp.getVehicleSpeed() < min) min = timestamp.getVehicleSpeed();
                        if (timestamp.getVehicleSpeed() > max) max = timestamp.getVehicleSpeed();
                        totalSpeed += timestamp.getVehicleSpeed();
                        counter ++;
                    }
                }
            }
        }

        double averageSpeed = totalSpeed / counter;
        if (Double.isNaN(averageSpeed)) averageSpeed = 0; // if average is NaN (not a number) then set to 0
        if (min == Integer.MAX_VALUE) min = 0;
        if (max == Integer.MIN_VALUE) max = 0;
        minAvMaxVehicleSpeed.insert(min);
        minAvMaxVehicleSpeed.insert(averageSpeed);
        minAvMaxVehicleSpeed.insert(max);

        //if there are no data (only 0 values) then return an empty AVL
        if (minAvMaxVehicleSpeed.size() == 1) {
            return new AVL<>();
        }

        return minAvMaxVehicleSpeed;

    }

    public AVL<Double> getMinAvMaxAbsoluteLoad(double dayNum1, double dayNum2, AVL<Vehicle> vehicleAVL, VehicleType vehicleTypeToMatch) {

        AVL<Double> minAvMaxAbsoluteLoad = new AVL<>();

        double totalAbsoluteLoad = 0;
        int counter = 0;
        double min = Integer.MAX_VALUE;
        double max = Integer.MIN_VALUE;

        for (Vehicle vehicle : vehicleAVL.inOrder()) {
            VehicleType vehicleType = ExerciseOne.getVehicleById(vehicle.getVehicleId(), vehicleAVL).getVehicleType();
            if (vehicleType != vehicleTypeToMatch) continue;
            for (Trip trip : vehicle.getTripAVL().inOrder()) {
                for (Day day : trip.getDayAVL().inOrder()) {
                    if (day.getDayNum() < dayNum1 || day.getDayNum() > dayNum2) continue;
                    for (Timestamp timestamp : day.getTimestampAVL().inOrder()) {
                        double absoluteLoad = Double.parseDouble(timestamp.getAbsoluteLoad());
                        if (Double.isNaN(absoluteLoad)) continue; // if speed is NaN (not a number) then skip
                        if (absoluteLoad < min) min = absoluteLoad;
                        if (absoluteLoad > max) max = absoluteLoad;
                        totalAbsoluteLoad += absoluteLoad;
                        counter ++;
                    }
                }
            }
        }

        double averageAbsoluteLoad = totalAbsoluteLoad / counter;
        if (Double.isNaN(averageAbsoluteLoad)) averageAbsoluteLoad = 0; // if average is NaN (not a number) then set to 0
        if (min == Integer.MAX_VALUE) min = 0;
        if (max == Integer.MIN_VALUE) max = 0;
        minAvMaxAbsoluteLoad.insert(min);
        minAvMaxAbsoluteLoad.insert(averageAbsoluteLoad);
        minAvMaxAbsoluteLoad.insert(max);

        //if there are no data (only 0 values) then return an empty AVL
        if (minAvMaxAbsoluteLoad.size() == 1) {
            return new AVL<>();
        }

        return minAvMaxAbsoluteLoad;

    }

    public AVL<Double> getMinAvMaxOAT(double dayNum1, double dayNum2, AVL<Vehicle> vehicleAVL, VehicleType vehicleTypeToMatch) {

        AVL<Double> minAvMaxOAT = new AVL<>();

        double totalOAT = 0;
        int counter = 0;
        double min = Integer.MAX_VALUE;
        double max = Integer.MIN_VALUE;

        for (Vehicle vehicle : vehicleAVL.inOrder()) {
            VehicleType vehicleType = ExerciseOne.getVehicleById(vehicle.getVehicleId(), vehicleAVL).getVehicleType();
            if (vehicleType != vehicleTypeToMatch) continue;
            for (Trip trip : vehicle.getTripAVL().inOrder()) {
                for (Day day : trip.getDayAVL().inOrder()) {
                    if (day.getDayNum() < dayNum1 || day.getDayNum() > dayNum2) continue;
                    for (Timestamp timestamp : day.getTimestampAVL().inOrder()) {
                        double oat = Double.parseDouble(timestamp.getOat());
                        if (Double.isNaN(oat)) continue; // if speed is NaN (not a number) then skip
                        if (oat < min) min = oat;
                        if (oat > max) max = oat;
                        totalOAT += oat;
                        counter ++;
                    }
                }
            }
        }

        double averageOAT = totalOAT / counter;
        if (Double.isNaN(averageOAT)) averageOAT = 0; // if average is NaN (not a number) then set to 0
        if (min == Integer.MAX_VALUE) min = 0;
        if (max == Integer.MIN_VALUE) max = 0;
        minAvMaxOAT.insert(min);
        minAvMaxOAT.insert(averageOAT);
        minAvMaxOAT.insert(max);

        //if there are no data (only 0 values) then return an empty AVL
        if (minAvMaxOAT.size() == 1) {
            return new AVL<>();
        }

        return minAvMaxOAT;

    }

}