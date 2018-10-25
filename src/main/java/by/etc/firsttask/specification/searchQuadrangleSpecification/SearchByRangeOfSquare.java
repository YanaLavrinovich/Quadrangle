package by.etc.firsttask.specification.searchQuadrangleSpecification;

import by.etc.firsttask.entity.Quadrangle;
import by.etc.firsttask.registrar.QuadrangleRegistrar;
import by.etc.firsttask.repository.QuadrangleRepository;
import by.etc.firsttask.specification.QuadrangleSpecification;
import by.etc.firsttask.storage.QuadrangleStorage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SearchByRangeOfSquare implements QuadrangleSpecification {
    private double from;
    private double to;

    private static final Logger LOGGER = LogManager.getLogger(SearchByRangeOfSquare.class.getName());

    public SearchByRangeOfSquare(double from, double to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public List<Quadrangle> execute(QuadrangleRepository repository) {
        QuadrangleStorage storage = QuadrangleStorage.getInstance();
        List<Quadrangle> resultOfSearching = new ArrayList<>();
        for(Map.Entry current : storage.getStorage().entrySet()) {
            QuadrangleRegistrar registrar = (QuadrangleRegistrar) current.getValue();
            if(registrar.getSquare() >= from &&
                    registrar.getSquare() <= to) {
                List<Quadrangle> quadrangles = repository.query(new SearchById((Integer)current.getKey()));
                resultOfSearching.addAll(quadrangles);
            }
        }
        LOGGER.debug("Search by range of square is done!");
        return resultOfSearching;
    }
}
