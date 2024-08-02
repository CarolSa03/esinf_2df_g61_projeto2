package esinf_2ndproject;

import java.awt.geom.Point2D;

/**
 * The interface Kd tree node interface.
 */
public interface KDTreeNodeInterface {

    /**
     * Gets coords.
     *
     * @return the coords
     */
    Point2D.Double getCoords();

    /**
     * Sets coords.
     *
     * @param coords the coords
     */
    void setCoords(Point2D.Double coords);

}