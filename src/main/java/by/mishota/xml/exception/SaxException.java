package by.mishota.xml.exception;

public class SaxException extends RuntimeException {

    public SaxException() {
    }

    public SaxException(String message) {
        super(message);
    }

    public SaxException(String message, Throwable cause) {
        super(message, cause);
    }

    public SaxException(Throwable cause) {
        super(cause);
    }
}
