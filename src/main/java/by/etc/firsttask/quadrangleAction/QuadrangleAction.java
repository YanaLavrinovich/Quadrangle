package by.etc.firsttask.quadrangleAction;

import by.etc.firsttask.entity.Point;
import by.etc.firsttask.entity.Quadrangle;

public interface QuadrangleAction {

    double calculateSquare(Quadrangle quadrangle);

    double calculatePerimeter(Quadrangle quadrangle);

    boolean isQuadrangle(Point vertex1, Point vertex2, Point vertex3, Point vertex4);

    boolean isConvex(Quadrangle quadrangle);

    boolean isSquare(Quadrangle quadrangle);

    boolean isRhombus(Quadrangle quadrangle);

    boolean isTrapeze(Quadrangle quadrangle);
}
