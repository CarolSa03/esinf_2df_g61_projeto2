package esinf_2ndproject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ExerciseFourTest {

    private AVL<Vehicle> vehicleAVL;
    private ExerciseFour exerciseFour;

    @BeforeEach
    void setUp() throws IOException {
        ReadFile.readFiles();
        exerciseFour = new ExerciseFour();
        vehicleAVL = ReadFile.getVehicleAVL();
    }

    @Test
    void testExistingId() {
        Set<Integer> vehIdSet = new HashSet<>();
        vehIdSet.add(10); //id exists

        int expectedSize = vehIdSet.size();
        int actualSize = exerciseFour.getLongestTripSet(vehIdSet, vehicleAVL).size();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    void testExistingAndNonExistingIds() {
        Set<Integer> vehIdSet = new HashSet<>();
        vehIdSet.add(10); //exists
        vehIdSet.add(140); //exists
        vehIdSet.add(156); //exists
        vehIdSet.add(100); //doesn't exist
        vehIdSet.add(22222); //doesn't exist
        vehIdSet.add(0); //doesn't exist

        int expectedSize = 3;
        int actualSize = exerciseFour.getLongestTripSet(vehIdSet, vehicleAVL).size();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    void testNonExistingId() {
        Set<Integer> vehIdSet = new HashSet<>();
        vehIdSet.add(219328); //id doesn't exist

        int expectedSize = 0;
        int actualSize = exerciseFour.getLongestTripSet(vehIdSet, vehicleAVL).size();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    void calculateDistanceTest() {
        Timestamp first = new Timestamp();
        first.setLatitude(40.7128);
        first.setLongitude(-74.0060);

        Timestamp last = new Timestamp();
        last.setLatitude(34.0522);
        last.setLongitude(-118.2437);

        double expectedDistance = 3935.75;

        double actualDistance = Utils.calculateDistance(first.getLatitude(), first.getLongitude(), last.getLatitude(), last.getLongitude());
        assertEquals(expectedDistance, actualDistance, 0.1);
    }

    @Test
    void testDataPrinter() {
        Set<Integer> vehIdSet = new HashSet<>();
        Set<LongestTrip> longestTripSet;

        vehIdSet.add(10); //exists
        vehIdSet.add(140); //exists
        vehIdSet.add(156); //exists
        vehIdSet.add(185); //exists
        vehIdSet.add(181); //exists
        vehIdSet.add(213); //exists
        vehIdSet.add(575); //exists
        vehIdSet.add(100); //doesn't exist
        vehIdSet.add(22222); //doesn't exist
        vehIdSet.add(0); //doesn't exist

        longestTripSet = exerciseFour.getLongestTripSet(vehIdSet, vehicleAVL);

        System.out.println("##### Data #####");

        for (LongestTrip trip : longestTripSet) {
            System.out.println("-----------------------");
            System.out.printf(" VehicleId : %9d \n", trip.getVehId());
            System.out.printf(" Trip : %14d\n", trip.getTrip().getTrip());
            System.out.printf(" Distance (km) : %5.2f \n", trip.getDistance());
            System.out.println("-----------------------");
            System.out.println();
        }

    }

}