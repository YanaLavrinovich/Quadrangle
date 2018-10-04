package by.etc.firsttask.readerFromFile;

import by.etc.firsttask.exception.ReaderIOException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.List;
import java.util.stream.Collectors;

public class ReaderFromFileImpl implements ReaderFromFile {
    private static final String THE_FILE_IS_NOT_FOUND_MESSAGE = "The file is not found!";

    public List<String> read(final Path path) throws ReaderIOException {
        try {
            return Files.lines(path).collect(Collectors.toList());
        } catch (IOException e) {
            throw new ReaderIOException(THE_FILE_IS_NOT_FOUND_MESSAGE, e.fillInStackTrace());
        }
    }
}
