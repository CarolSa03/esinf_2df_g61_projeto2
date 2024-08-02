package esinf_2ndproject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExerciseThreeTest {

    private ExerciseThree exerciseThree;

    private AVL<Trip> tripAVL;

    @BeforeEach
    void setUp() throws IOException {

        exerciseThree = new ExerciseThree();

        tripAVL = new AVL<>();

        ReadFile.readCopyFiles();

        tripAVL = ReadFile.getTripAVL();

    }

    @Test
    void getLongitudeAndLatitudeOfBeginningAndEndOfEachTrip() {

        List<String> expectedResult = new ArrayList<>();

        expectedResult.add("Trip 768 - Beginning: -83.77658167, 42.27414444");
        expectedResult.add("Trip 768 - End: -83.776855, 42.27447917");
        expectedResult.add("Trip 1389 - Beginning: -83.69887889, 42.27770444");
        expectedResult.add("Trip 1389 - End: -83.69887889, 42.27770444");
        expectedResult.add("Trip 1844 - Beginning: -83.73894528, 42.229295");
        expectedResult.add("Trip 1844 - End: -83.73894944, 42.22951528");
        expectedResult.add("Trip 2003 - Beginning: -83.73446917, 42.26920056");
        expectedResult.add("Trip 2003 - End: -83.73456056, 42.26927333");
        expectedResult.add("Trip 2213 - Beginning: -83.74321417, 42.28457278");
        expectedResult.add("Trip 2213 - End: -83.74323611, 42.28498694");
        expectedResult.add("Trip 2294 - Beginning: -83.71835944, 42.29039778");
        expectedResult.add("Trip 2294 - End: -83.71835944, 42.29039778");

        List<String> actualResult = exerciseThree.getLongitudeAndLatitudeOfBeginningAndEndOfEachTrip(tripAVL);

        assertEquals(expectedResult, actualResult);

    }

}