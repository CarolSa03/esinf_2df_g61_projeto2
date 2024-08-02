package esinf_2ndproject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ExerciseSixTest {

    AVL<Trip> tripAVL;
    AVL<Vehicle> vehicleAVL;
    ExerciseSix exerciseSix;

    @BeforeEach
    void setUp() throws IOException {
        ReadFile.readCopyFiles();

        tripAVL = ReadFile.getTripAVL();
        vehicleAVL = ReadFile.getVehicleAVL();

        exerciseSix = new ExerciseSix();
        exerciseSix.run(40, -90, 50, -80, 1, tripAVL);
    }

    @Test
    void getTopTripsAVL() {
        AVL<Trip> actual = ExerciseSix.getTopTripsAVL();
        AVL<Trip> expected = new AVL<>();

        expected.insert(new Trip(1844));

        assertEquals(expected.inOrder(), actual.inOrder());
    }

    @Test
    void createKDTree() {
        KdTree<GPS> actual = exerciseSix.createKDTree(tripAVL);
        KdTree<GPS> expected = new KdTree<>();

        expected.insert(new GPS(42.28457278, -83.74321417));
        expected.insert(new GPS(42.28498694, -83.74323611));
        expected.insert(new GPS(42.29039778, -83.71835944));
        expected.insert(new GPS(42.26920056, -83.73446917));
        expected.insert(new GPS(42.26927333, -83.73456056));
        expected.insert(new GPS(42.27770444, -83.69887889));
        expected.insert(new GPS(42.27447917, -83.776855));
        expected.insert(new GPS(42.229295, -83.73894528));
        expected.insert(new GPS(42.22951528, -83.73894944));

        assertEquals(actual.inOrder(), expected.inOrder());
    }

    @Test
    void getTopGPS() {
        GPS gps1 = new GPS(40, -90);
        GPS gps2 = new GPS(50, -80);
        KdTree<GPS> actual = exerciseSix.getTopGPS(gps1, gps2, 1, exerciseSix.createKDTree(tripAVL));
        KdTree<GPS> expected = new KdTree<>();

        expected.insert(new GPS(42.22951528, -83.73894944));

        assertEquals(expected.inOrder(), actual.inOrder());
    }
}