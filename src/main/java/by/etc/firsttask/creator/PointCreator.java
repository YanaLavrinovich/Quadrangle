package by.etc.firsttask.creator;

import by.etc.firsttask.entity.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PointCreator {
    private static final Logger LOGGER = LogManager.getLogger(PointCreator.class.getName());

    public List<Point> create(List<Double> coordinates) {
        Iterator<Double> iterator = coordinates.iterator();
        List<Point> quadrangleVertex = new ArrayList<>();
        while (iterator.hasNext()) {
            Point point = new Point(iterator.next(), iterator.next());
            quadrangleVertex.add(point);
        }
        LOGGER.info("Creation of quadrangle's vertexes is done");
        return quadrangleVertex;
    }
}
