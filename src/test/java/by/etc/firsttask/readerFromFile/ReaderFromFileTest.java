package by.etc.firsttask.readerFromFile;

import by.etc.firsttask.exception.ReaderFromFileException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReaderFromFileTest {
    private ReaderFromFile reader;

    @BeforeClass
    public void setUp() {
        reader = new ReaderFromFileImpl();
    }

    @DataProvider(name = "dataForReadFromFileTestPositive")
    public Object[][] dataForReadFromFileTestPositive() {
        Path path = Paths.get("resources/test1.txt");

        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("1 2 3 1 5 4 1 4");
        expectedResult.add("1 2 3 a 5 4 1 4");
        expectedResult.add("1 2 3 d1 5 4 1 4");
        expectedResult.add("1 2 3 1 5 4 1 4 1 2 3 1 5 4 1 4");
        expectedResult.add("1 2 3 1 5 4 1 4 6");
        expectedResult.add("1 2 we 1 5 4 1 4");
        expectedResult.add("fjsl kfs dfsl");
        expectedResult.add("1 2 3a 1 5 4v 1 4");
        expectedResult.add("1 2 3 c1 5 4 1 4");
        expectedResult.add("1 2 3s 1 5 4 1v 4");
        expectedResult.add("1 2 3 1 5");
        expectedResult.add("1 2 3 1ds 5 4 1 4");
        expectedResult.add("1 2ss 3 1 5 4 1 4");
        expectedResult.add("srf4d 34fsc 434dc 4r");
        expectedResult.add("1 1 1 3 2 3 2 1");

        return new Object[][]{{path, expectedResult}};
    }

    @Test(dataProvider = "dataForReadFromFileTestPositive")
    public void readFromFileTestPositive(Path path, List<String> expectedResult) {
        List<String> actual = new ArrayList<>();
        try {
            actual = reader.read(path);
        } catch (ReaderFromFileException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(expectedResult, actual);
    }
}
