package esinf_2ndproject;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class ExerciseTwoTest {

    private ExerciseTwo exerciseTwo;
    private AVL<Vehicle> vehicleAVL;
    private VehicleType vehicleTypeToMatch;

    @Before
    public void setUp() throws IOException {
        exerciseTwo = new ExerciseTwo();
        ReadFile.readCopyFiles();
        vehicleAVL = ReadFile.getVehicleAVL();
        vehicleTypeToMatch = VehicleType.ICE;
    }

    @Test
    public void testGetMinAvMaxVehicleSpeed() {

        AVL<Double> expectedResult = new AVL<>();

        expectedResult.insert(6.0);
        expectedResult.insert(36.86363636363637);
        expectedResult.insert(56.0);

        AVL<Double> actualResult = exerciseTwo.getMinAvMaxVehicleSpeed(1, 1000, vehicleAVL, vehicleTypeToMatch);

        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void testGetMinAvMaxAbsoluteLoad() {

        AVL<Double> expectedResult = new AVL<>();

        expectedResult.insert(10.98039246);
        expectedResult.insert(35.650625228636365);
        expectedResult.insert(81.17647552);

        AVL<Double> actualResult = exerciseTwo.getMinAvMaxAbsoluteLoad(1, 1000, vehicleAVL, vehicleTypeToMatch);

        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void testGetMinAvMaxOAT() {

        AVL<Double> expectedResult = new AVL<>();

        expectedResult.insert(-2.0);
        expectedResult.insert(0.23529411764705882);
        expectedResult.insert(2.0);

        AVL<Double> actualResult = exerciseTwo.getMinAvMaxOAT(1, 1000, vehicleAVL, vehicleTypeToMatch);

        assertEquals(expectedResult, actualResult);

    }
}