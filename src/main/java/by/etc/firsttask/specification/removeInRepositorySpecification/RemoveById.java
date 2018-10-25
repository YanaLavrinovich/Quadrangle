package by.etc.firsttask.specification.removeInRepositorySpecification;

import by.etc.firsttask.entity.Quadrangle;
import by.etc.firsttask.repository.QuadrangleRepository;
import by.etc.firsttask.specification.QuadrangleSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class RemoveById implements QuadrangleSpecification {
    private Integer id;

    private static final Logger LOGGER = LogManager.getLogger(RemoveById.class.getName());

    public RemoveById(Integer id) {
        this.id = id;
    }

    @Override
    public List<Quadrangle> execute(QuadrangleRepository repository) {
        List<Quadrangle> resultOfRemoving = new ArrayList<>();
        for(Quadrangle current : repository.getQuadrangles()) {
            if(current.getId().equals(id)) {
                resultOfRemoving.add(current);
            }
        }
        repository.getQuadrangles().removeAll(resultOfRemoving);
        LOGGER.debug("Removing by id is done!");
        return resultOfRemoving;
    }
}
