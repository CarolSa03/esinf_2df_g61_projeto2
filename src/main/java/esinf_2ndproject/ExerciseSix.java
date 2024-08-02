package esinf_2ndproject;

public class ExerciseSix {
    public static AVL<Trip> topTripsAVL = new AVL<>();
    public static KdTree<GPS> topGpsKdTree = new KdTree<>();

    public static AVL<Trip> getTopTripsAVL() {
        return topTripsAVL;
    }
    private static void setTopTripsAVL(AVL<Trip> topTripsAVL) {
        ExerciseSix.topTripsAVL = topTripsAVL;
    }

    public void run(double latitudeGPS1, double longitudeGPS1, double latitudeGPS2, double longitudeGPS2, int number, AVL<Trip> tripAVL) {
        GPS gps1;
        GPS gps2;

        if (latitudeGPS1 < latitudeGPS2) {
            if (longitudeGPS1 < longitudeGPS2) {
                gps1 = new GPS(latitudeGPS1, longitudeGPS1);
                gps2 = new GPS(latitudeGPS2, longitudeGPS2);
            } else {
                gps1 = new GPS(latitudeGPS1, longitudeGPS2);
                gps2 = new GPS(latitudeGPS2, longitudeGPS1);
            }
        } else if (latitudeGPS1 > latitudeGPS2) {
            if (longitudeGPS1 < longitudeGPS2) {
                gps1 = new GPS(latitudeGPS2, longitudeGPS1);
                gps2 = new GPS(latitudeGPS1, longitudeGPS2);
            } else {
                gps1 = new GPS(latitudeGPS2, longitudeGPS2);
                gps2 = new GPS(latitudeGPS1, longitudeGPS1);
            }
        } else {
            gps1 = new GPS(latitudeGPS1, longitudeGPS1);
            gps2 = new GPS(latitudeGPS2, longitudeGPS2);
        }

        KdTree<GPS> kdTree = createKDTree(tripAVL);
        topGpsKdTree = getTopGPS(gps1, gps2, number, kdTree);
        getTopTrips(topGpsKdTree, tripAVL);

    }

    public KdTree<GPS> createKDTree(AVL<Trip> tripAVL) {
        KdTree<GPS> kdTree = new KdTree<>();

        for (Trip trip : tripAVL.inOrder()) {
            for (Day day : trip.getDayAVL().inOrder()) {
                for (Timestamp timestamp : day.getTimestampAVL().inOrder()) {
                    GPS gps = new GPS(timestamp.getLatitude(), timestamp.getLongitude());
                    kdTree.insert(gps);
                }
            }
        }

        return kdTree;
    }

    public static KdTree<GPS> getTopGPS(GPS gps1, GPS gps2, int number, KdTree<GPS> kdTree) {
        topGpsKdTree = new KdTree<>();

        for (int i = 0; i < number; i++) {
            GPS max = kdTree.biggestElement();
            if(max == null) break;
            if (belongInArea(max, gps1, gps2)) {
                topGpsKdTree.insert(max);
            }
            kdTree.remove(max);
        }

        return topGpsKdTree;
    }

    public static boolean belongInArea(GPS max, GPS gps1, GPS gps2) {
        return max.compareTo(gps1) >= 0 && max.compareTo(gps2) <= 0;
    }

    public static void getTopTrips(KdTree<GPS> topGpsKdTree, AVL<Trip> tripAVL) {

        topTripsAVL = new AVL<>();

        for (Trip trip : tripAVL.inOrder()) {
            for (Day day : trip.getDayAVL().inOrder()) {
                for (Timestamp timestamp : day.getTimestampAVL().inOrder()) {
                    GPS gpsTrip = new GPS(timestamp.getLatitude(), timestamp.getLongitude());
                    for (GPS gps : topGpsKdTree.inOrder()) {
                        if (gps.equals(gpsTrip)) {
                            topTripsAVL.insert(trip);
                            topGpsKdTree.remove(gps);
                        }
                    }
                }
            }
        }
        setTopTripsAVL(topTripsAVL);
    }
}