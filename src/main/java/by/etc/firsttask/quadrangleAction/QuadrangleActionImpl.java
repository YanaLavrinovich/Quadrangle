package by.etc.firsttask.quadrangleAction;

import by.etc.firsttask.point.Point;
import by.etc.firsttask.pointAction.PointAction;
import by.etc.firsttask.pointAction.PointActionImpl;
import by.etc.firsttask.quadrangle.Quadrangle;

public class QuadrangleActionImpl implements QuadrangleAction {
    private PointAction pointAction;

    public QuadrangleActionImpl() {
        pointAction = new PointActionImpl();
    }

    @Override
    public double calculateSquare(Quadrangle quadrangle) {
        double halfPerimeter = calculatePerimeter(quadrangle) / 2;
        double side1 = pointAction.calculateDistance(quadrangle.getVertex1(), quadrangle.getVertex2());
        double side2 = pointAction.calculateDistance(quadrangle.getVertex2(), quadrangle.getVertex3());
        double side3 = pointAction.calculateDistance(quadrangle.getVertex3(), quadrangle.getVertex4());
        double side4 = pointAction.calculateDistance(quadrangle.getVertex4(), quadrangle.getVertex1());
        double square = Math.sqrt((halfPerimeter - side1) * (halfPerimeter - side2) *
                (halfPerimeter - side3) * (halfPerimeter - side4));
        return square;
    }

    @Override
    public double calculatePerimeter(Quadrangle quadrangle) {
        double perimeter = pointAction.calculateDistance(quadrangle.getVertex1(), quadrangle.getVertex2()) +
                pointAction.calculateDistance(quadrangle.getVertex2(), quadrangle.getVertex3()) +
                pointAction.calculateDistance(quadrangle.getVertex3(), quadrangle.getVertex4()) +
                pointAction.calculateDistance(quadrangle.getVertex4(), quadrangle.getVertex1());
        return perimeter;
    }

    @Override
    public boolean isQuadrangle(Quadrangle quadrangle) {
        Point vertex1 = quadrangle.getVertex1();
        Point vertex2 = quadrangle.getVertex2();
        Point vertex3 = quadrangle.getVertex3();
        Point vertex4 = quadrangle.getVertex4();

        if (vertex1.getCoordinateX() == vertex2.getCoordinateX() && vertex2.getCoordinateX() == vertex3.getCoordinateX() ||
                vertex1.getCoordinateX() == vertex2.getCoordinateX() && vertex2.getCoordinateX() == vertex4.getCoordinateX() ||
                vertex2.getCoordinateX() == vertex3.getCoordinateX() && vertex3.getCoordinateX() == vertex4.getCoordinateX() ||
                vertex1.getCoordinateX() == vertex3.getCoordinateX() && vertex3.getCoordinateX() == vertex4.getCoordinateX()) {
            return false;
        }
        if (vertex1.getCoordinateY() == vertex2.getCoordinateY() && vertex2.getCoordinateY() == vertex3.getCoordinateY() ||
                vertex1.getCoordinateY() == vertex2.getCoordinateY() && vertex2.getCoordinateY() == vertex4.getCoordinateY() ||
                vertex2.getCoordinateY() == vertex3.getCoordinateY() && vertex3.getCoordinateY() == vertex4.getCoordinateY() ||
                vertex1.getCoordinateY() == vertex3.getCoordinateY() && vertex3.getCoordinateY() == vertex4.getCoordinateY()) {
            return false;
        }

        if ((vertex3.getCoordinateX() - vertex1.getCoordinateX()) / (vertex2.getCoordinateX() - vertex1.getCoordinateX()) ==
                (vertex3.getCoordinateY() - vertex1.getCoordinateY()) / (vertex2.getCoordinateY() - vertex1.getCoordinateY())) {
            return false;
        }
        if ((vertex4.getCoordinateX() - vertex1.getCoordinateX()) / (vertex2.getCoordinateX() - vertex1.getCoordinateX()) ==
                (vertex4.getCoordinateY() - vertex1.getCoordinateY()) / (vertex2.getCoordinateY() - vertex1.getCoordinateY())) {
            return false;
        }
        if ((vertex4.getCoordinateX() - vertex1.getCoordinateX()) / (vertex3.getCoordinateX() - vertex1.getCoordinateX()) ==
                (vertex4.getCoordinateY() - vertex1.getCoordinateY()) / (vertex3.getCoordinateY() - vertex1.getCoordinateY())) {
            return false;
        }
        if ((vertex4.getCoordinateX() - vertex2.getCoordinateX()) / (vertex3.getCoordinateX() - vertex2.getCoordinateX()) ==
                (vertex4.getCoordinateY() - vertex2.getCoordinateY()) / (vertex3.getCoordinateY() - vertex2.getCoordinateY())) {
            return false;
        }

        return true;
    }

    @Override
    public boolean isConvex(Quadrangle quadrangle) {
        Point vertex1 = quadrangle.getVertex1();
        Point vertex2 = quadrangle.getVertex2();
        Point vertex3 = quadrangle.getVertex3();
        Point vertex4 = quadrangle.getVertex4();

        if (pointAction.calculateRotate(vertex1, vertex3, vertex2) *
                pointAction.calculateRotate(vertex1, vertex3, vertex4) < 0 &&
                pointAction.calculateRotate(vertex2, vertex4, vertex1) *
                        pointAction.calculateRotate(vertex2, vertex4, vertex3) < 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isSquare(Quadrangle quadrangle) {
        Point vertex1 = quadrangle.getVertex1();
        Point vertex2 = quadrangle.getVertex2();
        Point vertex3 = quadrangle.getVertex3();
        Point vertex4 = quadrangle.getVertex4();
        if (pointAction.calculateDistance(vertex1, vertex2) == pointAction.calculateDistance(vertex2, vertex3) &&
                pointAction.calculateDistance(vertex1, vertex2) == pointAction.calculateDistance(vertex3, vertex4) &&
                pointAction.calculateDistance(vertex1, vertex2) == pointAction.calculateDistance(vertex4, vertex1) &&
                pointAction.calculateDistance(vertex1, vertex3) == pointAction.calculateDistance(vertex2, vertex4)) {
            return true;
        }
        if (pointAction.calculateDistance(vertex1, vertex3) == pointAction.calculateDistance(vertex3, vertex2) &&
                pointAction.calculateDistance(vertex1, vertex3) == pointAction.calculateDistance(vertex2, vertex4) &&
                pointAction.calculateDistance(vertex1, vertex3) == pointAction.calculateDistance(vertex4, vertex1) &&
                pointAction.calculateDistance(vertex1, vertex2) == pointAction.calculateDistance(vertex3, vertex4)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isRhombus(Quadrangle quadrangle) {
        Point vertex1 = quadrangle.getVertex1();
        Point vertex2 = quadrangle.getVertex2();
        Point vertex3 = quadrangle.getVertex3();
        Point vertex4 = quadrangle.getVertex4();
        if (pointAction.calculateDistance(vertex1, vertex2) == pointAction.calculateDistance(vertex2, vertex3) &&
                pointAction.calculateDistance(vertex1, vertex2) == pointAction.calculateDistance(vertex3, vertex4) &&
                pointAction.calculateDistance(vertex1, vertex2) == pointAction.calculateDistance(vertex4, vertex1) &&
                pointAction.calculateDistance(vertex1, vertex3) != pointAction.calculateDistance(vertex2, vertex4)) {
            return true;
        }
        if (pointAction.calculateDistance(vertex1, vertex3) == pointAction.calculateDistance(vertex3, vertex2) &&
                pointAction.calculateDistance(vertex1, vertex3) == pointAction.calculateDistance(vertex2, vertex4) &&
                pointAction.calculateDistance(vertex1, vertex3) == pointAction.calculateDistance(vertex4, vertex1) &&
                pointAction.calculateDistance(vertex1, vertex2) != pointAction.calculateDistance(vertex3, vertex4)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isTrapeze(Quadrangle quadrangle) {
        Point vertex1 = quadrangle.getVertex1();
        Point vertex2 = quadrangle.getVertex2();
        Point vertex3 = quadrangle.getVertex3();
        Point vertex4 = quadrangle.getVertex4();

        if(vertex3.getCoordinateY() == vertex2.getCoordinateY() && vertex1.getCoordinateY() == vertex4.getCoordinateY() ^
                vertex1.getCoordinateX() == vertex2.getCoordinateX() && vertex3.getCoordinateX() == vertex4.getCoordinateX() ||
                vertex3.getCoordinateY() == vertex2.getCoordinateY() && vertex1.getCoordinateY() == vertex4.getCoordinateY() ^
                        vertex1.getCoordinateX() == vertex3.getCoordinateX() && vertex2.getCoordinateX() == vertex4.getCoordinateX() ||
                vertex3.getCoordinateY() == vertex4.getCoordinateY() && vertex1.getCoordinateY() == vertex2.getCoordinateY() ^
                        vertex1.getCoordinateX() == vertex3.getCoordinateX() && vertex2.getCoordinateX() == vertex4.getCoordinateX()) {
            return true;
        }
        return false;
    }
}
