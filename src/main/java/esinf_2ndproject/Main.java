package esinf_2ndproject;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    static AVL<Vehicle> vehicleAVL = new AVL<>();
    static AVL<Trip> tripAVL = new AVL<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.println("\nReading files...");
//        ReadFile.readFiles();
        ReadFile.readCopyFiles();

        System.out.println("Creating AVL trees...\n");
        vehicleAVL = ReadFile.getVehicleAVL();
        tripAVL = ReadFile.getTripAVL();

        System.out.print("What exercise do you want to see (1-6)? ");
        int exercise = scanner.nextInt();

        while (exercise < 1 || exercise > 6) {
            System.out.print("\nPlease choose a number between 1 and 6: ");
            exercise = scanner.nextInt();
        }

        switch (exercise) {
            case 1:
                displayEx1();
                break;
            case 2:
                displayEx2();
                break;
            case 3:
                displayEx3();
                break;
            case 4:
                displayEx4();
                break;
            case 5:
                displayEx5();
                break;
            case 6:
                displayEx6();
                break;
        }

    }

    private static void displayEx1() {

        System.out.println("\n###Exercise 1###");

        System.out.println("Find by Vehicle ID or trip ID? \n(1 - Vehicle ID, 2 - Trip ID)\n");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Vehicle Id: ");
                int vehId = scanner.nextInt();
                Vehicle vehicle = ExerciseOne.getVehicleById(vehId, vehicleAVL);
                if (vehicle == null) System.out.println("Vehicle not found");
                else System.out.println(vehicle);
                break;
            case 2:
                System.out.print("Trip Id: ");
                int tripId = scanner.nextInt();
                Trip trip = ExerciseOne.getTripById(tripId, tripAVL);
                if (trip == null) System.out.println("Trip not found");
                else System.out.println(trip);
                break;
        }
    }

    private static void displayEx2() {

        System.out.println("\n###Exercise 2###");

        ExerciseTwo exerciseTwo = new ExerciseTwo();

        System.out.println("Please enter the day number 1: ");
        int dayNum1 = scanner.nextInt();

        System.out.println("Please enter the day number 2: ");
        int dayNum2 = scanner.nextInt();

        System.out.println("\nIn the following AVLs, the first value is the minimum, the second is the average and the third is the maximum.");
        System.out.println("If any AVL is empty, it means that there are no data for that vehicle type in the given days.\n");

        AVL<Double> vehicleSpeedICE = exerciseTwo.getMinAvMaxVehicleSpeed(dayNum1, dayNum2, vehicleAVL, VehicleType.ICE);
        AVL<Double> absoluteLoadICE = exerciseTwo.getMinAvMaxAbsoluteLoad(dayNum1, dayNum2, vehicleAVL, VehicleType.ICE);
        AVL<Double> oatICE = exerciseTwo.getMinAvMaxOAT(dayNum1, dayNum2, vehicleAVL, VehicleType.ICE);

        AVL<Double> vehicleSpeedHEV = exerciseTwo.getMinAvMaxVehicleSpeed(dayNum1, dayNum2, vehicleAVL, VehicleType.HEV);
        AVL<Double> absoluteLoadHEV = exerciseTwo.getMinAvMaxAbsoluteLoad(dayNum1, dayNum2, vehicleAVL, VehicleType.HEV);
        AVL<Double> oatHEV = exerciseTwo.getMinAvMaxOAT(dayNum1, dayNum2, vehicleAVL, VehicleType.HEV);

        AVL<Double> vehicleSpeedPHEV = exerciseTwo.getMinAvMaxVehicleSpeed(dayNum1, dayNum2, vehicleAVL, VehicleType.PHEV);
        AVL<Double> absoluteLoadPHEV = exerciseTwo.getMinAvMaxAbsoluteLoad(dayNum1, dayNum2, vehicleAVL, VehicleType.PHEV);
        AVL<Double> oatPHEV = exerciseTwo.getMinAvMaxOAT(dayNum1, dayNum2, vehicleAVL, VehicleType.PHEV);

        AVL<Double> vehicleSpeedEV = exerciseTwo.getMinAvMaxVehicleSpeed(dayNum1, dayNum2, vehicleAVL, VehicleType.EV);
        AVL<Double> absoluteLoadEV = exerciseTwo.getMinAvMaxAbsoluteLoad(dayNum1, dayNum2, vehicleAVL, VehicleType.EV);
        AVL<Double> oatEV = exerciseTwo.getMinAvMaxOAT(dayNum1, dayNum2, vehicleAVL, VehicleType.EV);

        System.out.println("#ICE#");
        System.out.println("Vehicle Speed Minimum, Average and Maximum Values (in order): " + vehicleSpeedICE.inOrder());
        System.out.println("Absolute Load Minimum, Average and Maximum Values (in order): " + absoluteLoadICE.inOrder());
        System.out.println("OAT Minimum, Average and Maximum Values (in order): " + oatICE.inOrder());

        System.out.println("#HEV#");
        System.out.println("Vehicle Speed Minimum, Average and Maximum Values (in order): " + vehicleSpeedHEV.inOrder());
        System.out.println("Absolute Load Minimum, Average and Maximum Values (in order): " + absoluteLoadHEV.inOrder());
        System.out.println("OAT Minimum, Average and Maximum Values (in order): " + oatHEV.inOrder());

        System.out.println("#PHEV#");
        System.out.println("Vehicle Speed Minimum, Average and Maximum Values (in order): " + vehicleSpeedPHEV.inOrder());
        System.out.println("Absolute Load Minimum, Average and Maximum Values (in order): " + absoluteLoadPHEV.inOrder());
        System.out.println("OAT Minimum, Average and Maximum Values (in order): " + oatPHEV.inOrder());

        System.out.println("#EV#");
        System.out.println("Vehicle Speed Minimum, Average and Maximum Values (in order): " + vehicleSpeedEV.inOrder());
        System.out.println("Absolute Load Minimum, Average and Maximum Values (in order): " + absoluteLoadEV.inOrder());
        System.out.println("OAT Minimum, Average and Maximum Values (in order): " + oatEV.inOrder());

    }

    private static void displayEx3() {
        System.out.println("\n###Exercise 3###");

        ExerciseThree exerciseThree = new ExerciseThree();

        exerciseThree.getLongitudeAndLatitudeOfBeginningAndEndOfEachTrip(tripAVL).forEach(System.out::println);
    }

    private static void displayEx4() {

        System.out.println("\n###Exercise 4###");

        ExerciseFour exerciseFour = new ExerciseFour();

        Set<Integer> vehIds = new HashSet<>();
        System.out.println("Which vehicle ids do you want to check? (type 0 to stop)");
        int vehId = scanner.nextInt();
        while (vehId != 0) {
            vehIds.add(vehId);
            vehId = scanner.nextInt();
        }

        Set<LongestTrip> longestTrips = exerciseFour.getLongestTripSet(vehIds, vehicleAVL);

        for (LongestTrip trip : longestTrips) {
            System.out.println("Vehicule id: " + trip.getVehId());
            System.out.println("\nTrip: " + trip.getTrip().getTrip());
            System.out.println("\nDistance: " + trip.getDistance() + "\n");
        }

    }

    private static void displayEx5() {

        System.out.println("\n###Exercise 5###");

        ExerciseFive exerciseFive = new ExerciseFive();

        System.out.println("\nCoordinates Origin");
        System.out.print("Latitude: ");
        double latitudeGPS1 = scanner.nextDouble();
        System.out.print("Longitude: ");
        double longitudeGPS1 = scanner.nextDouble();
        System.out.println("\nCoordinates Destiny");
        System.out.print("Latitude: ");
        double latitudeGPS2 = scanner.nextDouble();
        System.out.print("Longitude: ");
        double longitudeGPS2 = scanner.nextDouble();

        Trip trip = exerciseFive.getClosestTrip(tripAVL, new GPS(latitudeGPS1, longitudeGPS1), new GPS(latitudeGPS2, longitudeGPS2));
        if(trip == null) System.out.println("\nNo trips found");
        else System.out.println("\n" + trip);
    }

    private static void displayEx6() {

        System.out.println("\n###Exercise 6###");

        ExerciseSix exerciseSix = new ExerciseSix();

        System.out.println("\nGeographic Area 1");
        System.out.print("Latitude: ");
        double latitudeGPS1 = scanner.nextDouble();
        System.out.print("Longitude: ");
        double longitudeGPS1 = scanner.nextDouble();
        System.out.println("\nGeographic Area 2");
        System.out.print("Latitude: ");
        double latitudeGPS2 = scanner.nextDouble();
        System.out.print("Longitude: ");
        double longitudeGPS2 = scanner.nextDouble();
        System.out.print("\nNumber of trips: ");
        int num = scanner.nextInt();

        exerciseSix.run(latitudeGPS1, longitudeGPS1, latitudeGPS2, longitudeGPS2, num, tripAVL);

        AVL<Trip> topTripsAVL = ExerciseSix.getTopTripsAVL();

        if (topTripsAVL.isEmpty()) {
            System.out.println("\nNo trips found in the given area");
        } else {
            for (Trip trip : topTripsAVL.inOrder()) {
                System.out.println("\n" + trip);
            }
        }
    }

}