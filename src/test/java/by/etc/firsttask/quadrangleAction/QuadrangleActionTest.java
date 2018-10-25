package by.etc.firsttask.quadrangleAction;

import by.etc.firsttask.entity.Point;
import by.etc.firsttask.entity.Quadrangle;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class QuadrangleActionTest {
    private QuadrangleAction quadrangleAction;
    @BeforeClass
    public void setUp() {
        quadrangleAction = new QuadrangleActionImpl();
    }

    @DataProvider(name = "dataForCalculatePerimeterTest")
    public Object[][] dataForCalculatePerimeterTest() {
        Quadrangle quadrangle = new Quadrangle(new Point(1,2), new Point(4,6),
                new Point(6, 6), new Point(6,2));
        double expectedResult = 16;
        return new Object[][]{{quadrangle, expectedResult}};
    }

    @Test(dataProvider = "dataForCalculatePerimeterTest")
    public void calculatePerimeterTest(Quadrangle quadrangle,  double expectedResult) {
        double actual = quadrangleAction.calculatePerimeter(quadrangle);
        Assert.assertEquals(expectedResult, actual);
    }

    @DataProvider(name = "dataForCalculateSquareTest")
    public Object[][] dataForCalculateSquareTest() {
        Quadrangle quadrangle = new Quadrangle(new Point(1,2), new Point(4,6),
                new Point(6, 6), new Point(6,2));
        double expectedResult = Math.sqrt(216);
        return new Object[][]{{quadrangle, expectedResult}};
    }

    @Test(dataProvider = "dataForCalculateSquareTest")
    public void calculateSquareTest(Quadrangle quadrangle,  double expectedResult) {
        double actual = quadrangleAction.calculateSquare(quadrangle);
        Assert.assertEquals(expectedResult, actual);
    }

    @DataProvider(name = "dataForIsQuadrangleTestPositive")
    public Object[][] dataForIsQuadrangleTestPositive() {
        Point vertex1 = new Point(1,2);
        Point vertex2 = new Point(4,6);
        Point vertex3 = new Point(6, 6);
        Point vertex4 = new Point(6,2);

        return new Object[][]{{vertex1, vertex2, vertex3, vertex4, true}};
    }

    @Test(dataProvider = "dataForIsQuadrangleTestPositive")
    public void isQuadrangleTestPositive(Point vertex1, Point vertex2, Point vertex3, Point vertex4,  boolean expectedResult) {
        boolean actual = quadrangleAction.isQuadrangle(vertex1, vertex2, vertex3, vertex4);
        Assert.assertEquals(expectedResult, actual);
    }

    @DataProvider(name = "dataForIsQuadrangleTestNegativeY")
    public Object[][] dataForIsQuadrangleTestNegativeY() {
        Point vertex1 = new Point(1,2);
        Point vertex2 = new Point(4,6);
        Point vertex3 = new Point(6, 6);
        Point vertex4 = new Point(8,6);

        return new Object[][]{{vertex1, vertex2, vertex3, vertex4, false}};
    }

    @Test(dataProvider = "dataForIsQuadrangleTestNegativeY")
    public void isQuadrangleTestNegativeY(Point vertex1, Point vertex2, Point vertex3, Point vertex4,  boolean expectedResult) {
        boolean actual = quadrangleAction.isQuadrangle(vertex1, vertex2, vertex3, vertex4);
        Assert.assertEquals(expectedResult, actual);
    }

    @DataProvider(name = "dataForIsQuadrangleTestNegativeYAndX")
    public Object[][] dataForIsQuadrangleTestNegativeYAndX() {
        Point vertex1 = new Point(1,1);
        Point vertex2 = new Point(4,6);
        Point vertex3 = new Point(6, 6);
        Point vertex4 = new Point(3,3);

        return new Object[][]{{vertex1, vertex2, vertex3, vertex4, false}};
    }

    @Test(dataProvider = "dataForIsQuadrangleTestNegativeYAndX")
    public void isQuadrangleTestNegativeYAndX(Point vertex1, Point vertex2, Point vertex3, Point vertex4,  boolean expectedResult) {
        boolean actual = quadrangleAction.isQuadrangle(vertex1, vertex2, vertex3, vertex4);
        Assert.assertEquals(expectedResult, actual);
    }

    @DataProvider(name = "dataForIsConvexTestPositive")
    public Object[][] dataForIsConvexTestPositive() {
        Quadrangle quadrangle = new Quadrangle(new Point(1,2), new Point(4,6),
                new Point(6, 6), new Point(6,2));
        return new Object[][]{{quadrangle}};
    }

    @Test(dataProvider = "dataForIsConvexTestPositive")
    public void isConvexTestPositive(Quadrangle quadrangle) {
        boolean actual = quadrangleAction.isConvex(quadrangle);
        Assert.assertTrue(actual);
    }

    @DataProvider(name = "dataForIsConvexTestNegative")
    public Object[][] dataForIsConvexTestNegative() {
        Quadrangle quadrangle = new Quadrangle(new Point(2,2), new Point(4,4),
                new Point(3, 2), new Point(4,1));
        return new Object[][]{{quadrangle}};
    }

    @Test(dataProvider = "dataForIsConvexTestNegative")
    public void isConvexTestNegative(Quadrangle quadrangle) {
        boolean actual = quadrangleAction.isConvex(quadrangle);
        Assert.assertFalse(actual);
    }

    @DataProvider(name = "dataForIsRhombusTestPositive")
    public Object[][] dataForIsRhombusTestPositive() {
        Quadrangle quadrangle = new Quadrangle(new Point(1,2), new Point(2,4),
                new Point(3, 2), new Point(2,0));
        return new Object[][]{{quadrangle}};
    }

    @Test(dataProvider = "dataForIsRhombusTestPositive")
    public void isRhombusTestPositive(Quadrangle quadrangle) {
        boolean actual = quadrangleAction.isRhombus(quadrangle);
        Assert.assertTrue(actual);
    }

    @DataProvider(name = "dataForIsRhombusTestNegative")
    public Object[][] dataForIsRhombusTestNegative() {
        Quadrangle quadrangle = new Quadrangle(new Point(1,1), new Point(2,2),
                new Point(3, 2), new Point(3,1));
        return new Object[][]{{quadrangle}};
    }

    @Test(dataProvider = "dataForIsRhombusTestNegative")
    public void isRhombusTestNegative(Quadrangle quadrangle) {
        boolean actual = quadrangleAction.isRhombus(quadrangle);
        Assert.assertFalse(actual);
    }

    @DataProvider(name = "dataForIsSquareTestPositive")
    public Object[][] dataForIsSquareTestPositive() {
        Quadrangle quadrangle = new Quadrangle(new Point(1,1), new Point(1,2),
                new Point(2, 2), new Point(2,1));
        return new Object[][]{{quadrangle}};
    }

    @Test(dataProvider = "dataForIsSquareTestPositive")
    public void isSquareTestPositive(Quadrangle quadrangle) {
        boolean actual = quadrangleAction.isSquare(quadrangle);
        Assert.assertTrue(actual);
    }

    @DataProvider(name = "dataForIsSquareTestNegative")
    public Object[][] dataForIsSquareTestNegative() {
        Quadrangle quadrangle = new Quadrangle(new Point(1,1), new Point(1,3),
                new Point(2, 3), new Point(2,1));
        return new Object[][]{{quadrangle}};
    }

    @Test(dataProvider = "dataForIsSquareTestNegative")
    public void isSquareTestNegative(Quadrangle quadrangle) {
        boolean actual = quadrangleAction.isSquare(quadrangle);
        Assert.assertFalse(actual);
    }

    //
    @DataProvider(name = "dataForIsTrapezeTestPositive")
    public Object[][] dataForIsTrapezeTestPositive() {
        Quadrangle quadrangle = new Quadrangle(new Point(1,1), new Point(2,3),
                new Point(4, 3), new Point(4,1));
        return new Object[][]{{quadrangle}};
    }

    @Test(dataProvider = "dataForIsTrapezeTestPositive")
    public void isTrapezeTestPositive(Quadrangle quadrangle) {
        boolean actual = quadrangleAction.isTrapeze(quadrangle);
        Assert.assertTrue(actual);
    }

    @DataProvider(name = "dataForIsTrapezeTestNegative")
    public Object[][] dataForIsTrapezeTestNegative() {
        Quadrangle quadrangle = new Quadrangle(new Point(1,1), new Point(1,3),
                new Point(2, 3), new Point(2,1));
        return new Object[][]{{quadrangle}};
    }

    @Test(dataProvider = "dataForIsTrapezeTestNegative")
    public void isTrapezeTestNegative(Quadrangle quadrangle) {
        boolean actual = quadrangleAction.isTrapeze(quadrangle);
        Assert.assertFalse(actual);
    }
}
