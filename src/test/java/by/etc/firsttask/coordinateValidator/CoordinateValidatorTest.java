package by.etc.firsttask.coordinateValidator;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class CoordinateValidatorTest {
    private CoordinateValidator coordinateValidator;

    @BeforeClass
    public void setUp() {
        coordinateValidator = new CoordinateValidatorImpl();
    }

    @Test
    public void isValidTestPositive() {
        String test = "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16";
        boolean actual = coordinateValidator.isValid(test);
        Assert.assertTrue(actual);
    }

    @Test
    public void isValidTestNegative() {
        String test = "1 a 3 4 5 6 7 8 9 10 11 12 13 14 15 16";
        boolean actual = coordinateValidator.isValid(test);
        Assert.assertFalse(actual);
    }
}
