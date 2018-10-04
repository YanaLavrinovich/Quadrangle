package by.etc.firsttask.reader;

import java.nio.file.Path;
import java.util.List;

public interface DataReader {

    List<String> readFromFile(final Path path) throws ReaderIOException;
}
