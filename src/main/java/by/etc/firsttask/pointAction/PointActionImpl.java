package by.etc.firsttask.pointAction;

import by.etc.firsttask.entity.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class PointActionImpl implements PointAction{
    private static final Logger LOGGER = LogManager.getLogger(PointActionImpl.class.getName());

    @Override
    public double calculateDistance(Point point1, Point point2) {
        double distance = Math.sqrt(Math.pow((point2.getCoordinateX() - point1.getCoordinateX()), 2) +
                Math.pow((point2.getCoordinateY() - point1.getCoordinateY()), 2));
        LOGGER.info("Distance between " + point1 + " and " + point2 + " is " + distance);
        return distance;
    }

    @Override
    public double calculateRotate(Point point1, Point point2, Point point3) {
        double rotate = (point2.getCoordinateX() - point1.getCoordinateX()) *
                (point3.getCoordinateY() - point2.getCoordinateY()) -
                (point2.getCoordinateY() - point1.getCoordinateY()) *
                        (point3.getCoordinateX() - point2.getCoordinateX());
        LOGGER.info("Rotate "  + rotate);
        return rotate;
    }
}
