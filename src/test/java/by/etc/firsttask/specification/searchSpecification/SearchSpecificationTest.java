package by.etc.firsttask.specification.searchSpecification;

import by.etc.firsttask.entity.Point;
import by.etc.firsttask.entity.Quadrangle;
import by.etc.firsttask.repository.QuadrangleRepository;
import by.etc.firsttask.specification.QuadrangleSpecification;
import by.etc.firsttask.specification.searchQuadrangleSpecification.SearchById;
import by.etc.firsttask.specification.searchQuadrangleSpecification.SearchByName;
import by.etc.firsttask.specification.searchQuadrangleSpecification.SearchByRangeOfPerimeter;
import by.etc.firsttask.specification.searchQuadrangleSpecification.SearchByRangeOfSquare;
import by.etc.firsttask.storage.QuadrangleStorage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class SearchSpecificationTest {
    private QuadrangleRepository repository;
    private QuadrangleSpecification specification;

    @BeforeClass
    public void setUp() {
        repository = QuadrangleRepository.getInstance();
        repository.subscribe(QuadrangleStorage.getInstance());
    }

    @DataProvider(name = "dataForSearchByIdTestPositive")
    public Object[][] dataForSearchByIdTestPositive() {
        repository.getQuadrangles().clear();
        Quadrangle quadrangle = new Quadrangle(new Point(1,2), new Point(3,4),
                new Point(5,6), new Point(7,8));
        Integer id = 1;
        quadrangle.setId(id);
        repository.add(quadrangle);
        List<Quadrangle> expectedResult = List.of(quadrangle);
        return new Object[][] {{id, expectedResult}};
    }

    @Test(dataProvider = "dataForSearchByIdTestPositive")
    public void searchByIdTestPositive(Integer id, List<Quadrangle> expectedResult) {
        specification = new SearchById(id);
        List<Quadrangle> actual = specification.execute(repository);
        Assert.assertEquals(expectedResult,actual);
    }

    @DataProvider(name = "dataForSearchByNameTestPositive")
    public Object[][] dataForSearchByNameTestPositive() {
        repository.getQuadrangles().clear();
        Quadrangle quadrangle = new Quadrangle(new Point(1,2), new Point(3,4),
                new Point(5,6), new Point(7,8));
        String name = "test";
        quadrangle.setName(name);
        repository.add(quadrangle);
        List<Quadrangle> expectedResult = List.of(quadrangle);
        return new Object[][] {{name, expectedResult}};
    }

    @Test(dataProvider = "dataForSearchByNameTestPositive")
    public void searchByNameTestPositive(String id, List<Quadrangle> expectedResult) {
        specification = new SearchByName(id);
        List<Quadrangle> actual = specification.execute(repository);
        Assert.assertEquals(expectedResult,actual);
    }

    @DataProvider(name = "dataForSearchByRangeOfPerimeter")
    public Object[][] dataForSearchByRangeOfPerimeter() {
        repository.getQuadrangles().clear();
        Quadrangle quadrangle = new Quadrangle(new Point(1,1), new Point(1,2),
                new Point(2,2), new Point(2,1));
        Double from = 3.0;
        Double to = 5.0;
        quadrangle.setId(3);
        repository.add(quadrangle);
        List<Quadrangle> expectedResult = List.of(quadrangle);
        return new Object[][] {{from, to, expectedResult}};
    }

    @Test(dataProvider = "dataForSearchByRangeOfPerimeter")
    public void searchByRangeOfPerimeterTestPositive(Double from, Double to, List<Quadrangle> expectedResult) {
        specification = new SearchByRangeOfPerimeter(from, to);
        List<Quadrangle> actual = specification.execute(repository);
        Assert.assertEquals(expectedResult,actual);
    }

    @DataProvider(name = "dataForSearchByRangeOfSquare")
    public Object[][] dataForSearchByRangeOfSquare() {
        repository.getQuadrangles().clear();
        Quadrangle quadrangle = new Quadrangle(new Point(1,1), new Point(1,2),
                new Point(2,2), new Point(2,1));
        Double from = 0.0;
        Double to = 2.0;
        quadrangle.setId(3);
        repository.add(quadrangle);
        List<Quadrangle> expectedResult = List.of(quadrangle);
        return new Object[][] {{from, to, expectedResult}};
    }

    @Test(dataProvider = "dataForSearchByRangeOfSquare")
    public void searchByRangeOfSquareTestPositive(Double from, Double to, List<Quadrangle> expectedResult) {
        specification = new SearchByRangeOfSquare(from, to);
        List<Quadrangle> actual = specification.execute(repository);
        Assert.assertEquals(expectedResult,actual);
    }

}
