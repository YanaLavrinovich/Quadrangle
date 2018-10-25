package by.etc.firsttask.specification;

import by.etc.firsttask.entity.Quadrangle;
import by.etc.firsttask.repository.QuadrangleRepository;

import java.util.List;

public interface QuadrangleSpecification {

    List<Quadrangle> execute(QuadrangleRepository repository);
}
