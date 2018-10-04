package by.etc.firsttask.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.List;
import java.util.stream.Collectors;

public class DataReaderImpl implements DataReader{
    private static final String THE_FILE_IS_NOT_FOUND_MESSAGE = "The file is not found!";

    public List<String> readFromFile(final Path path) throws ReaderIOException {
        try {
            return Files.lines(path).collect(Collectors.toList());
        } catch (IOException e) {
            throw new ReaderIOException(THE_FILE_IS_NOT_FOUND_MESSAGE, e.fillInStackTrace());
        }
    }
}
