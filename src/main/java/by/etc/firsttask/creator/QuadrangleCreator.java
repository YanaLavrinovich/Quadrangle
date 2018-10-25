package by.etc.firsttask.creator;

import by.etc.firsttask.entity.Point;
import by.etc.firsttask.entity.Quadrangle;
import by.etc.firsttask.generator.GeneratorId;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class QuadrangleCreator {
    private PointCreator pointCreator;

    private static final Logger LOGGER = LogManager.getLogger(QuadrangleCreator.class.getName());

    private static final String QUADRANGLE_NAME = "Quadrangle";
    private static final int INDEX_VERTEX_1 = 0;
    private static final int INDEX_VERTEX_2 = 1;
    private static final int INDEX_VERTEX_3 = 2;
    private static final int INDEX_VERTEX_4 = 3;

    public QuadrangleCreator() {

    }

    public Quadrangle create(List<Double> coordinates) {
        Integer quadrangleId = GeneratorId.generate();
        pointCreator = new PointCreator();
        Point vertex1, vertex2, vertex3, vertex4;
        List<Point> quadrangleVertex = pointCreator.create(coordinates);
        vertex1 = quadrangleVertex.get(INDEX_VERTEX_1);
        vertex2 = quadrangleVertex.get(INDEX_VERTEX_2);
        vertex3 = quadrangleVertex.get(INDEX_VERTEX_3);
        vertex4 = quadrangleVertex.get(INDEX_VERTEX_4);
        Quadrangle newQuadrangle = new Quadrangle(vertex1, vertex2, vertex3, vertex4);
        newQuadrangle.setId(quadrangleId);
        newQuadrangle.setName(QUADRANGLE_NAME);
        LOGGER.info("Creation of quadrangle is done" + newQuadrangle);
        return newQuadrangle;
    }
}
