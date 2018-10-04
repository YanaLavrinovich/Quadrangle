package by.etc.firsttask.validator;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ValidatorTest {
    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        validator = new ValidatorImpl();
    }

    @Test
    public void validList() {
        boolean expected = true;
        String test = "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16";
        boolean actual = validator.validList(test);
        Assert.assertEquals(expected, actual);
    }
}
