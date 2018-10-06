package by.etc.firsttask.point;

import java.io.Serializable;
import java.util.Random;

public class Point implements Serializable {

    private double coordinateX;
    private double coordinateY;

    public Point(double coordinateX, double coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public double getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(double coordinateX) {
        this.coordinateX = coordinateX;
    }

    public double getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(double coordinateY) {
        this.coordinateY = coordinateY;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Point point = (Point) obj;
        return point.getCoordinateX() == this.getCoordinateX() &&
                point.getCoordinateY() == this.getCoordinateY();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = new Random().nextInt(255);
        result = prime * result + (int) this.getCoordinateX();
        result = prime * result + (int) this.getCoordinateY();
        return result;
    }

    @Override
    public String toString() {
        return String.format("Entity %s [x %.2f, y %.2f]",
                getClass().getName(), getCoordinateX(),getCoordinateY());
    }
}