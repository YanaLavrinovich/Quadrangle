package by.etc.firsttask.pointAction;

import by.etc.firsttask.point.Point;
import org.apache.log4j.Logger;


public class PointActionImpl implements PointAction {

    @Override
    public double calculateDistance(Point point1, Point point2) {
        double distance = Math.sqrt(Math.pow((point2.getCoordinateX() - point1.getCoordinateX()), 2) +
                Math.pow((point2.getCoordinateY() - point1.getCoordinateY()), 2));
        return distance;
    }

    @Override
    public double calculateRotate(Point point1, Point point2, Point point3) {
        double rotate = (point2.getCoordinateX() - point1.getCoordinateX()) *
                (point3.getCoordinateY() - point2.getCoordinateY()) -
                (point2.getCoordinateY() - point1.getCoordinateY()) *
                        (point3.getCoordinateX() - point2.getCoordinateX());
        return rotate;
    }
}
