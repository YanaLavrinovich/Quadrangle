package by.etc.firsttask.registrar;


public class QuadrangleRegistrar {
    private Double square;
    private Double perimeter;

    public QuadrangleRegistrar(Double square, Double perimeter) {
        this.square = square;
        this.perimeter = perimeter;
    }

    public Double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    public Double getSquare() {
        return square;
    }

    public void setSquare(Double square) {
        this.square = square;
    }
}
