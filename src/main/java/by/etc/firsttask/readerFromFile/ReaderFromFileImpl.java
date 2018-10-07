package by.etc.firsttask.readerFromFile;

import by.etc.firsttask.exception.ReaderFromFileException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.List;
import java.util.stream.Collectors;

public class ReaderFromFileImpl implements ReaderFromFile {
    private static final String THE_FILE_IS_NOT_FOUND_MESSAGE = "The file is not found!";

    @Override
    public List<String> read(Path path) throws ReaderFromFileException {
        try {
            return Files.lines(path).collect(Collectors.toList());
        } catch (IOException e) {
            throw new ReaderFromFileException(THE_FILE_IS_NOT_FOUND_MESSAGE, e);
        }
    }
}
