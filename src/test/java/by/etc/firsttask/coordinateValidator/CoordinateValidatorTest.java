package by.etc.firsttask.coordinateValidator;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CoordinateValidatorTest {
    private CoordinateValidator coordinateValidator;

    @BeforeClass
    public void setUp() {
        coordinateValidator = new CoordinateValidatorImpl();
    }

    @DataProvider(name = "dataForIsValidTestPositive")
    public Object[][] dataForIsValidTestPositive() {
        String test1 = "1 2 3 4 5 6 7 8";
        String test2 = "1 2.0 3 4.7 5 6 7 8";
        return new Object[][]{{test1, true},
                              {test2, true}};
    }

    @Test(dataProvider = "dataForIsValidTestPositive")
    public void isValidTestPositive(String data, boolean expectedResult) {
        boolean actual = coordinateValidator.isValid(data);
        Assert.assertEquals(expectedResult, actual);
    }

    @DataProvider(name = "dataForIsValidTestNegative")
    public Object[][] dataForIsValidTestNegative() {
        String test1 = "1 2 3 4 5 6 ";
        String test2 = "1 2.0 3 -4 5a 6 7 8";
        return new Object[][]{{test1, false},
                {test2, false}};
    }

    @Test(dataProvider = "dataForIsValidTestNegative")
    public void isValidTestNegative(String data, boolean expectedResult) {
        String test = "1 a 3 4 5 6 7 8 9 10 11 12 13 14 15 16";
        boolean actual = coordinateValidator.isValid(data);
        Assert.assertEquals(expectedResult, actual);
    }
}
