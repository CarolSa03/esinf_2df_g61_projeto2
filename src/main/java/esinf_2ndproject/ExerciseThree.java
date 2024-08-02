package esinf_2ndproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExerciseThree {
    public List<String> getLongitudeAndLatitudeOfBeginningAndEndOfEachTrip(AVL<Trip> tripAVL) {
        List<String> result = new ArrayList<>();

        Map<Trip, Timestamp> tripToBeginningTimestamp = new HashMap<>();
        Map<Trip, Timestamp> tripToEndTimestamp = new HashMap<>();

        for (Trip trip : tripAVL.inOrder()) {
            Timestamp beginningTimestamp = null;
            Timestamp endTimestamp = null;

            for (Day day : trip.getDayAVL().inOrder()) {
                AVL<Timestamp> timestampAVL = day.getTimestampAVL();
                Timestamp smallest = timestampAVL.smallestElement();
                Timestamp biggest = timestampAVL.biggestElement();

                if (beginningTimestamp == null || smallest.getTimestamp() < beginningTimestamp.getTimestamp()) {
                    beginningTimestamp = smallest;
                }

                if (endTimestamp == null || biggest.getTimestamp() > endTimestamp.getTimestamp()) {
                    endTimestamp = biggest;
                }
            }

            tripToBeginningTimestamp.put(trip, beginningTimestamp);
            tripToEndTimestamp.put(trip, endTimestamp);
        }

        for (Trip trip : tripAVL.inOrder()) {
            result.add("Trip " + trip.getTrip() + " - Beginning: " + tripToBeginningTimestamp.get(trip).getLongitude() + ", " + tripToBeginningTimestamp.get(trip).getLatitude());
            result.add("Trip " + trip.getTrip() + " - End: " + tripToEndTimestamp.get(trip).getLongitude() + ", " + tripToEndTimestamp.get(trip).getLatitude());
        }

        return result;
    }
}
