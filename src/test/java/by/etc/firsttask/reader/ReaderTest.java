package by.etc.firsttask.reader;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReaderTest {
    private static DataReader reader;

    @BeforeClass
    public static void setUp() {
        reader = new DataReaderImpl();
    }
    @Test
    public void readFromFile() {
        Path path = Paths.get("File/test1.txt");
        List<String> actual = new ArrayList<>();
        try {
            actual = reader.readFromFile(path);
        } catch (ReaderIOException e) {
            e.printStackTrace();
        }
        List<String> expected = new ArrayList<>();
        expected.add("1 2 3 1 5 4 1 4 3 6 5 -3");
        Assert.assertEquals(expected, actual);
    }
}
