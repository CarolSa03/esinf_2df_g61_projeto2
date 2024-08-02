package esinf_2ndproject;

import java.awt.geom.Point2D;
import java.util.Objects;

/**
 * The type Gps.
 */
public class GPS implements Comparable<GPS>, KDTreeNodeInterface {

    private Point2D.Double coords;

    /**
     * Instantiates a new Gps.
     *
     * @param latitude  the latitude
     * @param longitude the longitude
     */
    public GPS(double latitude, double longitude) {
        setCoords(new Point2D.Double(latitude, longitude));
    }

    public GPS(Point2D.Double coords) {
        setCoords(coords);
    }

    public Point2D.Double getCoords() {
        return coords;
    }

    public void setCoords(Point2D.Double coords) {
        this.coords = coords;
    }

    @Override
    public String toString() {
        return "GPS{" +
                "latitude=" + coords.getX() +
                ", longitude=" + coords.getY() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GPS gps = (GPS) o;
        return this.coords.equals(gps.coords);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coords);
    }

    @Override
    public int compareTo(GPS o) {
        int cmpLatitude = Double.compare(this.coords.getX(), o.coords.getX());

        if (cmpLatitude == 0) {
            return Double.compare(this.coords.getY(), o.coords.getY());
        } else {
            return cmpLatitude;
        }
    }
}
