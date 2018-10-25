package by.etc.firsttask.specification.removeSpecification;

import by.etc.firsttask.entity.Point;
import by.etc.firsttask.entity.Quadrangle;
import by.etc.firsttask.repository.QuadrangleRepository;
import by.etc.firsttask.specification.QuadrangleSpecification;
import by.etc.firsttask.specification.removeInRepositorySpecification.RemoveById;
import by.etc.firsttask.specification.removeInRepositorySpecification.RemoveByName;
import by.etc.firsttask.specification.sortQuadrangleSpecification.SortById;
import by.etc.firsttask.storage.QuadrangleStorage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class RemoveInRepositorySpecificationTest {
    private QuadrangleRepository repository;
    private QuadrangleSpecification specification;

    @BeforeClass
    public void setUp() {
        repository = QuadrangleRepository.getInstance();
        repository.subscribe(QuadrangleStorage.getInstance());
    }

    @DataProvider(name = "dataForRemoveByIdTestPositive")
    public Object[][] dataForRemoveByIdTestPositive() {
        repository.getQuadrangles().clear();
        Quadrangle quadrangle1 = new Quadrangle(new Point(1,2), new Point(3,4),
                new Point(5,6), new Point(7,8));
        Quadrangle quadrangle2 = new Quadrangle(new Point(1,2), new Point(3,4),
                new Point(5,6), new Point(7,8));
        Integer id = 1;
        quadrangle1.setId(id);
        quadrangle2.setId(2);
        repository.add(quadrangle1);
        repository.add(quadrangle2);
        List<Quadrangle> expectedResult = List.of(quadrangle1);
        return new Object[][] {{id, expectedResult}};
    }

    @Test(dataProvider = "dataForRemoveByIdTestPositive")
    public void removeByIdTestPositive(Integer id, List<Quadrangle> expectedResult) {
        specification = new RemoveById(id);
        List<Quadrangle> actual = specification.execute(repository);
        Assert.assertEquals(expectedResult,actual);
    }

    @DataProvider(name = "dataForRemoveByNameTestPositive")
    public Object[][] dataForRemoveByNameTestPositive() {
        repository.getQuadrangles().clear();
        Quadrangle quadrangle1 = new Quadrangle(new Point(1,2), new Point(3,4),
                new Point(5,6), new Point(7,8));
        Quadrangle quadrangle2 = new Quadrangle(new Point(1,2), new Point(3,4),
                new Point(5,6), new Point(7,8));
        String name = "aaa";
        quadrangle1.setName(name);
        quadrangle2.setName("bbb");
        repository.add(quadrangle1);
        repository.add(quadrangle2);
        List<Quadrangle> expectedResult = List.of(quadrangle1);
        return new Object[][] {{name, expectedResult}};
    }

    @Test(dataProvider = "dataForRemoveByNameTestPositive")
    public void removeByNameTestPositive(String name, List<Quadrangle> expectedResult) {
        specification = new RemoveByName(name);
        List<Quadrangle> actual = specification.execute(repository);
        Assert.assertEquals(expectedResult,actual);
    }
}
