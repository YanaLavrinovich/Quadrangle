package by.etc.firsttask.specification.searchQuadrangleSpecification;

import by.etc.firsttask.entity.Quadrangle;
import by.etc.firsttask.repository.QuadrangleRepository;
import by.etc.firsttask.specification.QuadrangleSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class SearchById implements QuadrangleSpecification {
    private Integer id;

    private static final Logger LOGGER = LogManager.getLogger(SearchById.class.getName());

    public SearchById(Integer id) {
        this.id = id;
    }

    @Override
    public List<Quadrangle> execute(QuadrangleRepository repository) {
        List<Quadrangle> resultOfSearching = new ArrayList<>();
        for(Quadrangle current : repository.getQuadrangles()) {
            if(current.getId().equals(id)) {
                resultOfSearching.add(current);
            }
        }
        LOGGER.debug("Search by id is done!");
        return resultOfSearching;
    }
}
