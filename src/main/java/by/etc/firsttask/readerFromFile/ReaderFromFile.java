package by.etc.firsttask.readerFromFile;

import by.etc.firsttask.exception.ReaderFromFileException;

import java.nio.file.Path;
import java.util.List;

public interface ReaderFromFile {

    List<String> read(final Path path) throws ReaderFromFileException;
}
