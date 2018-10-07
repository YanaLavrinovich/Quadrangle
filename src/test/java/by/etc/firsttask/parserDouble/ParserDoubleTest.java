package by.etc.firsttask.parserDouble;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ParserDoubleTest {
    private ParserDouble parserDouble;

    @BeforeClass
    public void setUp() {
        parserDouble = new ParserDoubleImpl();
    }

    @DataProvider(name = "dataForParseTestPositive")
    public Object[][] dataForParseTestPositive() {
        List<String> data = new ArrayList<>();
        data.add("1 2 3 4 5 6 7 8");
        List<List<Double>> expectedResult = new ArrayList<>();
        List<Double> list = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0);
        expectedResult.add(list);
        return new Object[][]{{data, expectedResult}};
    }

    @Test(dataProvider = "dataForParseTestPositive")
    public void parseTestPositive(List<String> data, List<List<Double>> expectedResult) {
        List<List<Double>> actual = parserDouble.parse(data);
        Assert.assertEquals(expectedResult, actual);
    }

    @DataProvider(name = "dataForParseTestNegative")
    public Object[][] dataForParseTestNegative() {
        List<String> data = new ArrayList<>();
        data.add("1 2 3 4 5 6 7");
        List<List<Double>> expectedResult = Collections.emptyList();

        return new Object[][]{{data, expectedResult}};
    }

    @Test(dataProvider = "dataForParseTestNegative")
    public void parseTestNegative(List<String> data, List<List<Double>> expectedResult) {
        List<List<Double>> actual = parserDouble.parse(data);
        Assert.assertEquals(expectedResult, actual);
    }
}
