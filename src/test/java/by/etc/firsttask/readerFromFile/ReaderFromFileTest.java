package by.etc.firsttask.readerFromFile;

import by.etc.firsttask.exception.ReaderIOException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReaderFromFileTest {
    private static ReaderFromFile reader;

    @BeforeClass
    public static void setUp() {
        reader = new ReaderFromFileImpl();
    }

    @Test
    public void readFromFileTestPositive() {
        Path path = Paths.get("File/test1.txt");
        List<String> actual = new ArrayList<>();
        try {
            actual = reader.read(path);
        } catch (ReaderIOException e) {
            e.printStackTrace();
        }
        List<String> expected = new ArrayList<>();
        expected.add("1 2 3 1 5 4 1 4 3 6 5 -3");
        Assert.assertEquals(expected, actual);
    }

}
