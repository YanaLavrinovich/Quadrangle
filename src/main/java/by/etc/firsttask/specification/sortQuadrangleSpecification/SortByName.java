package by.etc.firsttask.specification.sortQuadrangleSpecification;

import by.etc.firsttask.entity.Quadrangle;
import by.etc.firsttask.repository.QuadrangleRepository;
import by.etc.firsttask.specification.QuadrangleSpecification;

import java.util.Comparator;
import java.util.List;

public class SortByName implements QuadrangleSpecification {

    @Override
    public List<Quadrangle> execute(QuadrangleRepository repository) {
        List<Quadrangle> sortedList = repository.getQuadrangles();
        Comparator<Quadrangle> comparator =
                Comparator.comparing(Quadrangle::getName);
        sortedList.sort(comparator);
        return sortedList;
    }
}
