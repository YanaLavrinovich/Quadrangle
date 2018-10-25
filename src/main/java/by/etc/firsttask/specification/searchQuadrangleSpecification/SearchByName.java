package by.etc.firsttask.specification.searchQuadrangleSpecification;

import by.etc.firsttask.entity.Quadrangle;
import by.etc.firsttask.repository.QuadrangleRepository;
import by.etc.firsttask.specification.QuadrangleSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class SearchByName implements QuadrangleSpecification {
    private String name;

    private static final Logger LOGGER = LogManager.getLogger(SearchByName.class.getName());

    public SearchByName(String name) {
        this.name = name;
    }

    @Override
    public List<Quadrangle> execute(QuadrangleRepository repository) {
        List<Quadrangle> resultOfSearching = new ArrayList<>();
        for(Quadrangle current : repository.getQuadrangles()) {
            if(current.getName().equals(name)) {
                resultOfSearching.add(current);
            }
        }
        LOGGER.debug("Search by name is done!");
        return resultOfSearching;
    }
}
