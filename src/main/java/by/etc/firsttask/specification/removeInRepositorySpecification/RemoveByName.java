package by.etc.firsttask.specification.removeInRepositorySpecification;

import by.etc.firsttask.entity.Quadrangle;
import by.etc.firsttask.repository.QuadrangleRepository;
import by.etc.firsttask.specification.QuadrangleSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class RemoveByName implements QuadrangleSpecification {
    private String name;

    private static final Logger LOGGER = LogManager.getLogger(RemoveByName.class.getName());

    public RemoveByName(String name) {
        this.name = name;
    }

    @Override
    public List<Quadrangle> execute(QuadrangleRepository repository) {
        List<Quadrangle> resultOfRemoving = new ArrayList<>();
        for(Quadrangle current : repository.getQuadrangles()) {
            if(current.getName().equals(name)) {
                resultOfRemoving.add(current);
            }
        }
        repository.getQuadrangles().removeAll(resultOfRemoving);
        LOGGER.debug("Removing by name is done!");
        return resultOfRemoving;
    }
}
