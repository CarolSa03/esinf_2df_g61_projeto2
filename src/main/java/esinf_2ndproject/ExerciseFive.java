package esinf_2ndproject;

public class ExerciseFive {

    public Trip getClosestTrip(AVL<Trip> tripAVL, GPS origin, GPS destiny) {

        Trip closestTrip = new Trip();
        double minorDistance = Double.MAX_VALUE;

        for (Trip trip : tripAVL.inOrder()) {
            KdTree<GPS> gpsKdTree = createKdTree(tripAVL, trip);

            KdTree.KdNode<GPS> originGpsKdNode = new KdTree.KdNode<>(origin, null, null);
            KdTree.KdNode<GPS> closestOriginGpsNode = gpsKdTree.root();
            GPS originNearestNeighbour = gpsKdTree.findNearestNeighbour(originGpsKdNode,
                    origin.getCoords().getX(), origin.getCoords().getY(), closestOriginGpsNode, true);

            KdTree.KdNode<GPS> destinyGpsKdNode = new KdTree.KdNode<>(destiny, null, null);
            KdTree.KdNode<GPS> closestDestinyGpsNode = gpsKdTree.root();
            GPS destinyNearestNeighbour = gpsKdTree.findNearestNeighbour(destinyGpsKdNode,
                    destiny.getCoords().getX(), destiny.getCoords().getY(), closestDestinyGpsNode, true);

            if (originNearestNeighbour != null && destinyNearestNeighbour != null) {
                double distance = originNearestNeighbour.getCoords().distance(origin.getCoords()) +
                        destinyNearestNeighbour.getCoords().distance(destiny.getCoords());

                if (distance < minorDistance) {
                    minorDistance = distance;
                    closestTrip = trip;
                }
            }

        }

        return closestTrip;

    }

    private KdTree<GPS> createKdTree(AVL<Trip> tripAVL, Trip tripId) {
        KdTree<GPS> gpsKdTree = new KdTree<>();
        for (Trip trip : tripAVL.inOrder()) {
            if (trip.equals(tripId)) {
                for (Day day : trip.getDayAVL().inOrder()) {
                    Timestamp timestampOrigin = day.getTimestampAVL().smallestElement();
                    Timestamp timestampDestiny = day.getTimestampAVL().biggestElement();

                    // Check if timestampOrigin and timestampDestiny are not null
                    if (timestampOrigin != null && timestampDestiny != null) {
                        GPS originGPS = new GPS(timestampOrigin.getLatitude(), timestampOrigin.getLongitude());
                        GPS destinyGPS = new GPS(timestampDestiny.getLatitude(), timestampDestiny.getLongitude());

                        // Check if originGPS and destinyGPS have non-null coordinates
                        if (originGPS.getCoords() != null && destinyGPS.getCoords() != null) {
                            gpsKdTree.insert(originGPS);
                            gpsKdTree.insert(destinyGPS);
                        }
                    }
                }
            }
        }
        return gpsKdTree;
    }

}