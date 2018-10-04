package by.etc.firsttask.reader;

public class ReaderIOException extends Exception{

    public ReaderIOException() {
    }

    public ReaderIOException(String message) {
        super(message);
    }

    public ReaderIOException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReaderIOException(Throwable cause) {
        super(cause);
    }
}
