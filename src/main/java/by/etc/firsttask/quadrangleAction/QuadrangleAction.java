package by.etc.firsttask.quadrangleAction;

import by.etc.firsttask.quadrangle.Quadrangle;

public interface QuadrangleAction {

    double calculateSquare(Quadrangle quadrangle);

    double calculatePerimeter(Quadrangle quadrangle);

    boolean isQuadrangle(Quadrangle quadrangle);

    boolean isConvex(Quadrangle quadrangle);

    boolean isSquare(Quadrangle quadrangle);

    boolean isRhombus(Quadrangle quadrangle);

    boolean isTrapeze(Quadrangle quadrangle);
}
