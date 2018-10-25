package by.etc.firsttask.quadrangleAction;

import by.etc.firsttask.entity.Point;
import by.etc.firsttask.entity.Quadrangle;
import by.etc.firsttask.pointAction.PointAction;
import by.etc.firsttask.pointAction.PointActionImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QuadrangleActionImpl implements QuadrangleAction {
    private PointAction pointAction;

    private static final Logger LOGGER = LogManager.getLogger(QuadrangleActionImpl.class);

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
        LOGGER.info("Quadrangle's square is " + square);
        return square;
    }

    @Override
    public double calculatePerimeter(Quadrangle quadrangle) {
        double perimeter = pointAction.calculateDistance(quadrangle.getVertex1(), quadrangle.getVertex2()) +
                pointAction.calculateDistance(quadrangle.getVertex2(), quadrangle.getVertex3()) +
                pointAction.calculateDistance(quadrangle.getVertex3(), quadrangle.getVertex4()) +
                pointAction.calculateDistance(quadrangle.getVertex4(), quadrangle.getVertex1());
        LOGGER.info("Quadrangle's perimeter is " + perimeter);
        return perimeter;
    }

    @Override
    public boolean isQuadrangle(Point vertex1, Point vertex2, Point vertex3, Point vertex4) {
        if (vertex1.getCoordinateX() == vertex2.getCoordinateX() && vertex2.getCoordinateX() == vertex3.getCoordinateX() ||
                vertex1.getCoordinateX() == vertex2.getCoordinateX() && vertex2.getCoordinateX() == vertex4.getCoordinateX() ||
                vertex2.getCoordinateX() == vertex3.getCoordinateX() && vertex3.getCoordinateX() == vertex4.getCoordinateX() ||
                vertex1.getCoordinateX() == vertex3.getCoordinateX() && vertex3.getCoordinateX() == vertex4.getCoordinateX()) {
            LOGGER.info("These points aren't correct for creation of quadrangle");
            return false;
        }
        if (vertex1.getCoordinateY() == vertex2.getCoordinateY() && vertex2.getCoordinateY() == vertex3.getCoordinateY() ||
                vertex1.getCoordinateY() == vertex2.getCoordinateY() && vertex2.getCoordinateY() == vertex4.getCoordinateY() ||
                vertex2.getCoordinateY() == vertex3.getCoordinateY() && vertex3.getCoordinateY() == vertex4.getCoordinateY() ||
                vertex1.getCoordinateY() == vertex3.getCoordinateY() && vertex3.getCoordinateY() == vertex4.getCoordinateY()) {
            LOGGER.info("These points aren't correct for creation of quadrangle");
            return false;
        }

        if ((vertex3.getCoordinateX() - vertex1.getCoordinateX()) / (vertex2.getCoordinateX() - vertex1.getCoordinateX()) ==
                (vertex3.getCoordinateY() - vertex1.getCoordinateY()) / (vertex2.getCoordinateY() - vertex1.getCoordinateY())) {
            LOGGER.info("These points aren't correct for creation of quadrangle");
            return false;
        }
        if ((vertex4.getCoordinateX() - vertex1.getCoordinateX()) / (vertex2.getCoordinateX() - vertex1.getCoordinateX()) ==
                (vertex4.getCoordinateY() - vertex1.getCoordinateY()) / (vertex2.getCoordinateY() - vertex1.getCoordinateY())) {
            LOGGER.info("These points aren't correct for creation of quadrangle");
            return false;
        }
        if ((vertex4.getCoordinateX() - vertex1.getCoordinateX()) / (vertex3.getCoordinateX() - vertex1.getCoordinateX()) ==
                (vertex4.getCoordinateY() - vertex1.getCoordinateY()) / (vertex3.getCoordinateY() - vertex1.getCoordinateY())) {
            LOGGER.info("These points aren't correct for creation of quadrangle");
            return false;
        }
        if ((vertex4.getCoordinateX() - vertex2.getCoordinateX()) / (vertex3.getCoordinateX() - vertex2.getCoordinateX()) ==
                (vertex4.getCoordinateY() - vertex2.getCoordinateY()) / (vertex3.getCoordinateY() - vertex2.getCoordinateY())) {
            LOGGER.info("These points aren't correct for creation of quadrangle");
            return false;
        }
        LOGGER.info("These points are correct for creation of quadrangle");
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
            LOGGER.info("This quadrangle is convex");
            return true;
        } else {
            LOGGER.info("This quadrangle isn't convex");
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
            LOGGER.info("This quadrangle is square");
            return true;
        }
        if (pointAction.calculateDistance(vertex1, vertex3) == pointAction.calculateDistance(vertex3, vertex2) &&
                pointAction.calculateDistance(vertex1, vertex3) == pointAction.calculateDistance(vertex2, vertex4) &&
                pointAction.calculateDistance(vertex1, vertex3) == pointAction.calculateDistance(vertex4, vertex1) &&
                pointAction.calculateDistance(vertex1, vertex2) == pointAction.calculateDistance(vertex3, vertex4)) {
            LOGGER.info("This quadrangle is square");
            return true;
        }
        LOGGER.info("This quadrangle isn't square");
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
            LOGGER.info("This quadrangle is rhombus");
            return true;
        }
        if (pointAction.calculateDistance(vertex1, vertex3) == pointAction.calculateDistance(vertex3, vertex2) &&
                pointAction.calculateDistance(vertex1, vertex3) == pointAction.calculateDistance(vertex2, vertex4) &&
                pointAction.calculateDistance(vertex1, vertex3) == pointAction.calculateDistance(vertex4, vertex1) &&
                pointAction.calculateDistance(vertex1, vertex2) != pointAction.calculateDistance(vertex3, vertex4)) {
            LOGGER.info("This quadrangle is rhombus");
            return true;
        }
        LOGGER.info("This quadrangle isn't rhombus");
        return false;
    }

    @Override
    public boolean isTrapeze(Quadrangle quadrangle) {
        Point vertex1 = quadrangle.getVertex1();
        Point vertex2 = quadrangle.getVertex2();
        Point vertex3 = quadrangle.getVertex3();
        Point vertex4 = quadrangle.getVertex4();

        if (vertex3.getCoordinateY() == vertex2.getCoordinateY() && vertex1.getCoordinateY() == vertex4.getCoordinateY() ^
                vertex1.getCoordinateX() == vertex2.getCoordinateX() && vertex3.getCoordinateX() == vertex4.getCoordinateX() ||
                vertex3.getCoordinateY() == vertex2.getCoordinateY() && vertex1.getCoordinateY() == vertex4.getCoordinateY() ^
                        vertex1.getCoordinateX() == vertex3.getCoordinateX() && vertex2.getCoordinateX() == vertex4.getCoordinateX() ||
                vertex3.getCoordinateY() == vertex4.getCoordinateY() && vertex1.getCoordinateY() == vertex2.getCoordinateY() ^
                        vertex1.getCoordinateX() == vertex3.getCoordinateX() && vertex2.getCoordinateX() == vertex4.getCoordinateX()) {
            LOGGER.info("This quadrangle is trapeze");
            return true;
        }
        LOGGER.info("This quadrangle isn't trapeze");
        return false;
    }
}
