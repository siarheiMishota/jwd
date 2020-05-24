package by.mishota.xml.exception;

public class StaxException extends RuntimeException {

    public StaxException() {
    }

    public StaxException(String message) {
        super(message);
    }

    public StaxException(String message, Throwable cause) {
        super(message, cause);
    }

    public StaxException(Throwable cause) {
        super(cause);
    }
}
