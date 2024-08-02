package esinf_2ndproject;

import java.util.HashSet;
import java.util.Set;

public class ExerciseFour {

    public Set<LongestTrip> getLongestTripSet(Set<Integer> vehIdSet, AVL<Vehicle> vehicleAVL) {

        Set<LongestTrip> set = new HashSet<>();

        Trip biggestTrip = null;

        for (Integer vehId : vehIdSet) {
            if (ExerciseOne.getVehicleById(vehId, vehicleAVL) == null) {
                System.out.println("### Vehicle ID \"" + vehId + "\" doesn't match to any existing vehicle. ### \n");
            } else {
                AVL<Trip> tripAVL = ExerciseOne.getVehicleById(vehId, vehicleAVL).getTripAVL();

                int currentId = vehId;
                double biggestDistance = 0;
                for (Trip trip : tripAVL.inOrder()) {
                    AVL<Day> dayAVL = trip.getDayAVL();
                    for (Day day : dayAVL.inOrder()) {
                        AVL<Timestamp> timestampAVL = day.getTimestampAVL();
                        Timestamp first = timestampAVL.smallestElement();
                        Timestamp last = timestampAVL.biggestElement();
                        double distance = Utils.calculateDistance(first.getLatitude(), first.getLongitude(), last.getLatitude(), last.getLongitude());
                        if (distance > biggestDistance) {
                            biggestDistance = distance;
                            biggestTrip = trip;
                        }
                    }
                }
                LongestTrip longestTrip = new LongestTrip(currentId, biggestTrip, biggestDistance);
                set.add(longestTrip);
            }
        }

        return set;
    }


}
