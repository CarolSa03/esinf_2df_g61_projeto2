package esinf_2ndproject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ExerciseFiveTest {

    private ExerciseFive exerciseFive;
    private AVL<Trip> tripAVL;

    @BeforeEach
    void setUp() throws IOException {

        exerciseFive = new ExerciseFive();
        ReadFile.readCopyFiles();
        tripAVL = ReadFile.getTripAVL();

    }

    @Test
    void getClosestTrip() {

        Trip expectedResult = new Trip();


    }

}