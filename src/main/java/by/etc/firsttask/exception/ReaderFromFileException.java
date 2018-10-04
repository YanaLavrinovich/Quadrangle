package by.etc.firsttask.exception;

public class ReaderFromFileException extends Exception{

    public ReaderFromFileException() {
    }

    public ReaderFromFileException(String message) {
        super(message);
    }

    public ReaderFromFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReaderFromFileException(Throwable cause) {
        super(cause);
    }
}
