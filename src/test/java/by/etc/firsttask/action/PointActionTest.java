package by.etc.firsttask.action;

import by.etc.firsttask.entity.Point;
import by.etc.firsttask.pointAction.PointAction;
import by.etc.firsttask.pointAction.PointActionImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PointActionTest {
    private PointAction pointAction;

    @BeforeClass
    public void setUp() {
        pointAction = new PointActionImpl();
    }

    @DataProvider(name = "dataForCalculateDistanceTest")
    public Object[][] dataForCalculateDistanceTest() {
        Point point1 = new Point(4, 6);
        Point point2 = new Point(1, 2);
        double expectedResult = 5;
        return new Object[][]{{point1, point2, expectedResult}};
    }

    @Test(dataProvider = "dataForCalculateDistanceTest")
    public void calculateDistanceTest(Point point1, Point point2, double expectedResult) {
        double actual = pointAction.calculateDistance(point1, point2);
        Assert.assertEquals(expectedResult, actual);
    }

    @DataProvider(name = "dataForCalculateRotateTest")
    public Object[][] dataForCalculateRotateTest() {
        Point point1 = new Point(1, 1);
        Point point2 = new Point(4, 4);
        Point point3 = new Point(2, 3);
        double expectedResult = 3;
        return new Object[][]{{point1, point2, point3, expectedResult}};
    }

    @Test(dataProvider = "dataForCalculateRotateTest")
    public void calculateRotateTest(Point point1, Point point2, Point point3, double expectedResult) {
        double actual = pointAction.calculateRotate(point1, point2, point3);
        Assert.assertEquals(expectedResult, actual);
    }
}
