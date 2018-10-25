package by.etc.firsttask.pointAction;

import by.etc.firsttask.entity.Point;

public interface PointAction {

    double calculateDistance(Point point1, Point point2);

    double calculateRotate(Point point1, Point point2, Point point3);
}
