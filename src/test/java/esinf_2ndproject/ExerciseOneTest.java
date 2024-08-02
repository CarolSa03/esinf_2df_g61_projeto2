package esinf_2ndproject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ExerciseOneTest {
    AVL<Vehicle> vehicleAVL;
    AVL<Trip> tripAVL;
    Vehicle vehicle0;
    Vehicle vehicle1;
    Vehicle vehicle2;
    Vehicle vehicle3;
    Trip trip0;
    Trip trip1;
    Trip trip2;
    Trip trip3;

    @BeforeEach
    void setUp() {
        //Create Vehicles
        vehicle0 = new Vehicle(0);
        vehicle1 = new Vehicle(1);
        vehicle2 = new Vehicle(2);
        vehicle3 = new Vehicle(3);

        //Create Vehicle AVL
        vehicleAVL = new AVL<>();

        //Fill Vehicle AVL
        vehicleAVL.insert(vehicle0);
        vehicleAVL.insert(vehicle1);
        vehicleAVL.insert(vehicle2);
        vehicleAVL.insert(vehicle3);

        //Create Trips
        trip0 = new Trip(0);
        trip1 = new Trip(1);
        trip2 = new Trip(2);
        trip3 = new Trip(3);

        //Create Trip AVL
        tripAVL = new AVL<>();

        //Fill Trip AVL
        tripAVL.insert(trip0);
        tripAVL.insert(trip1);
        tripAVL.insert(trip2);
        tripAVL.insert(trip3);

        //Set Vehicles to Trips
        trip0.setVehicleId(0);
        trip1.setVehicleId(1);
        trip2.setVehicleId(2);
        trip3.setVehicleId(3);

        //Set Trips to VehiclesAVL
        vehicle0.getTripAVL().insert(trip0);
        vehicle1.getTripAVL().insert(trip1);
        vehicle2.getTripAVL().insert(trip2);
        vehicle3.getTripAVL().insert(trip3);

        //Set Vehicles to Trips
        vehicle0.getTripAVL().insert(trip0);
        vehicle1.getTripAVL().insert(trip1);
        vehicle2.getTripAVL().insert(trip2);
        vehicle3.getTripAVL().insert(trip3);

    }

    @Test
    void getVehicleByIdWithExistingVehicle() {
        Vehicle vehicleExpected0 = ExerciseOne.getVehicleById(0, vehicleAVL);
        Vehicle vehicleActual0 = new Vehicle(0);
        vehicleActual0.getTripAVL().insert(trip0);
        assertEquals(vehicleExpected0.getVehicleId(), vehicleActual0.getVehicleId());
        assertEquals(vehicleExpected0.getTripAVL(), vehicleActual0.getTripAVL());

        Vehicle vehicleExpected1 = ExerciseOne.getVehicleById(1, vehicleAVL);
        Vehicle vehicleActual1 = new Vehicle(1);
        vehicleActual1.getTripAVL().insert(trip1);
        assertEquals(vehicleExpected1.getVehicleId(), vehicleActual1.getVehicleId());
        assertEquals(vehicleExpected1.getTripAVL(), vehicleActual1.getTripAVL());

        Vehicle vehicleExpected2 = ExerciseOne.getVehicleById(2, vehicleAVL);
        Vehicle vehicleActual2 = new Vehicle(2);
        vehicleActual2.getTripAVL().insert(trip2);
        assertEquals(vehicleExpected2.getVehicleId(), vehicleActual2.getVehicleId());
        assertEquals(vehicleExpected2.getTripAVL(), vehicleActual2.getTripAVL());

        Vehicle vehicleExpected3 = ExerciseOne.getVehicleById(3, vehicleAVL);
        Vehicle vehicleActual3 = new Vehicle(3);
        vehicleActual3.getTripAVL().insert(trip3);
        assertEquals(vehicleExpected3.getVehicleId(), vehicleActual3.getVehicleId());
        assertEquals(vehicleExpected3.getTripAVL(), vehicleActual3.getTripAVL());
    }

    @Test
    void getVehicleByIdWithNonExistingVehicle() {
        Vehicle vehicleExpected = ExerciseOne.getVehicleById(6, vehicleAVL);
        assertNull(vehicleExpected);
    }

    @Test
    void getTripByIdWithExistingTrip() {
        Trip tripExpected0 = ExerciseOne.getTripById(0, tripAVL);
        Trip tripActual0 = new Trip(0);
        tripActual0.setVehicleId(vehicle0.getVehicleId());
        assertEquals(tripExpected0.getTrip(), tripActual0.getTrip());
        assertEquals(tripExpected0.getVehicleId(), tripActual0.getVehicleId());

        Trip tripExpected1 = ExerciseOne.getTripById(1, tripAVL);
        Trip tripActual1 = new Trip(1);
        tripActual1.setVehicleId(vehicle1.getVehicleId());
        assertEquals(tripExpected1.getTrip(), tripActual1.getTrip());
        assertEquals(tripExpected1.getVehicleId(), tripActual1.getVehicleId());

        Trip tripExpected2 = ExerciseOne.getTripById(2, tripAVL);
        Trip tripActual2 = new Trip(2);
        tripActual2.setVehicleId(vehicle2.getVehicleId());
        assertEquals(tripExpected2.getTrip(), tripActual2.getTrip());
        assertEquals(tripExpected2.getVehicleId(), tripActual2.getVehicleId());

        Trip tripExpected3 = ExerciseOne.getTripById(3, tripAVL);
        Trip tripActual3 = new Trip(3);
        tripActual3.setVehicleId(vehicle3.getVehicleId());
        assertEquals(tripExpected3.getTrip(), tripActual3.getTrip());
        assertEquals(tripExpected3.getVehicleId(), tripActual3.getVehicleId());
    }

    @Test
    void getTripByIdWithNonExistingTrip() {
        Trip tripExpected = ExerciseOne.getTripById(6, tripAVL);
        assertNull(tripExpected);
    }

    @Test
    void getVehiclesWithSameTrip() {
        //Set Vehicles to Trips
        trip0.getVehicleTripAVL().insert(0);
        trip0.getVehicleTripAVL().insert(1);

        //Set Trips to VehiclesAVL
        vehicle0.getTripAVL().insert(trip0);
        vehicle1.getTripAVL().insert(trip0);

        AVL<Vehicle> expected = new AVL<>();
        expected.insert(vehicle0);
        expected.insert(vehicle1);

        Trip trip = ExerciseOne.getTripById(trip0.getTrip(), tripAVL);

        AVL<Vehicle> actual = new AVL<>();

        for (Integer vehicle : trip.getVehicleTripAVL().inOrder()) {
            actual.insert(new Vehicle(vehicle));
        }

        assertEquals(expected, actual);
    }

    @Test
    void getVehiclesWithDifferentTrip() {
        //Set Vehicles to Trips
        trip2.getVehicleTripAVL().insert(0);
        trip3.getVehicleTripAVL().insert(1);

        //Set Trips to VehiclesAVL
        vehicle0.getTripAVL().insert(trip2);
        vehicle1.getTripAVL().insert(trip3);

        AVL<Vehicle> expected = new AVL<>();
        expected.insert(vehicle0);
        expected.insert(vehicle1);

        Trip trip = ExerciseOne.getTripById(trip2.getTrip(), tripAVL);

        AVL<Vehicle> actual = new AVL<>();

        for (Integer vehicle : trip.getVehicleTripAVL().inOrder()) {
            actual.insert(new Vehicle(vehicle));
        }

        assertNotEquals(expected, actual);
    }
}