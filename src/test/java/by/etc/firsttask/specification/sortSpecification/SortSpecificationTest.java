package by.etc.firsttask.specification.sortSpecification;

import by.etc.firsttask.entity.Point;
import by.etc.firsttask.entity.Quadrangle;
import by.etc.firsttask.repository.QuadrangleRepository;
import by.etc.firsttask.specification.QuadrangleSpecification;
import by.etc.firsttask.specification.sortQuadrangleSpecification.SortById;
import by.etc.firsttask.specification.sortQuadrangleSpecification.SortByName;
import by.etc.firsttask.specification.sortQuadrangleSpecification.SortByXOfFirstVertex;
import by.etc.firsttask.specification.sortQuadrangleSpecification.SortByYOfFirstVertex;
import by.etc.firsttask.storage.QuadrangleStorage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class SortSpecificationTest {
    private QuadrangleRepository repository;
    private QuadrangleSpecification specification;

    @BeforeClass
    public void setUp() {
        repository = QuadrangleRepository.getInstance();
        repository.subscribe(QuadrangleStorage.getInstance());
    }

    @DataProvider(name = "dataForSortByIdTestPositive")
    public Object[][] dataForSortByIdTestPositive() {
        repository.getQuadrangles().clear();
        Quadrangle quadrangle1 = new Quadrangle(new Point(1,2), new Point(3,4),
                new Point(5,6), new Point(7,8));
        Quadrangle quadrangle2 = new Quadrangle(new Point(1,2), new Point(3,4),
                new Point(5,6), new Point(7,8));
        quadrangle1.setId(1);
        quadrangle2.setId(2);
        repository.add(quadrangle2);
        repository.add(quadrangle1);
        List<Quadrangle> expectedResult = List.of(quadrangle1, quadrangle2);
        return new Object[][] {{expectedResult}};
    }

    @Test(dataProvider = "dataForSortByIdTestPositive")
    public void sortByIdTestPositive(List<Quadrangle> expectedResult) {
        specification = new SortById();
        List<Quadrangle> actual = specification.execute(repository);
        Assert.assertEquals(expectedResult,actual);
    }

    @DataProvider(name = "dataForSortByNameTestPositive")
    public Object[][] dataForSortByNameTestPositive() {
        repository.getQuadrangles().clear();
        Quadrangle quadrangle1 = new Quadrangle(new Point(1,2), new Point(3,4),
                new Point(5,6), new Point(7,8));
        Quadrangle quadrangle2 = new Quadrangle(new Point(1,2), new Point(3,4),
                new Point(5,6), new Point(7,8));
        quadrangle1.setName("aaa");
        quadrangle2.setName("bbb");
        repository.add(quadrangle2);
        repository.add(quadrangle1);
        List<Quadrangle> expectedResult = List.of(quadrangle1, quadrangle2);
        return new Object[][] {{expectedResult}};
    }

    @Test(dataProvider = "dataForSortByNameTestPositive")
    public void sortByNameTestPositive(List<Quadrangle> expectedResult) {
        specification = new SortByName();
        List<Quadrangle> actual = specification.execute(repository);
        Assert.assertEquals(expectedResult,actual);
    }

    @DataProvider(name = "dataForSortByXOfFirstVertexTestPositive")
    public Object[][] dataForSortByXOfFirstVertexTestPositive() {
        repository.getQuadrangles().clear();
        Quadrangle quadrangle1 = new Quadrangle(new Point(1,2), new Point(3,4),
                new Point(5,6), new Point(7,8));
        Quadrangle quadrangle2 = new Quadrangle(new Point(5,2), new Point(3,4),
                new Point(5,6), new Point(7,8));
        repository.add(quadrangle2);
        repository.add(quadrangle1);
        List<Quadrangle> expectedResult = List.of(quadrangle1, quadrangle2);
        return new Object[][] {{expectedResult}};
    }

    @Test(dataProvider = "dataForSortByXOfFirstVertexTestPositive")
    public void sortByXOfFirstVertexTestPositive(List<Quadrangle> expectedResult) {
        specification = new SortByXOfFirstVertex();
        List<Quadrangle> actual = specification.execute(repository);
        Assert.assertEquals(expectedResult,actual);
    }

    @DataProvider(name = "dataForSortByYOfFirstVertexTestPositive")
    public Object[][] dataForSortByYOfFirstVertexTestPositive() {
        repository.getQuadrangles().clear();
        Quadrangle quadrangle1 = new Quadrangle(new Point(1,2), new Point(3,4),
                new Point(1,6), new Point(7,8));
        Quadrangle quadrangle2 = new Quadrangle(new Point(1,6), new Point(3,4),
                new Point(5,6), new Point(7,8));
        repository.add(quadrangle2);
        repository.add(quadrangle1);
        List<Quadrangle> expectedResult = List.of(quadrangle1, quadrangle2);
        return new Object[][] {{expectedResult}};
    }

    @Test(dataProvider = "dataForSortByYOfFirstVertexTestPositive")
    public void sortByYOfFirstVertexTestPositive(List<Quadrangle> expectedResult) {
        specification = new SortByYOfFirstVertex();
        List<Quadrangle> actual = specification.execute(repository);
        Assert.assertEquals(expectedResult,actual);
    }
}
