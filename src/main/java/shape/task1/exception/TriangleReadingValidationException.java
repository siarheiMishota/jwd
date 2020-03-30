package shape.task1.exception;

public class TriangleReadingValidationException extends RuntimeException{

    public TriangleReadingValidationException() {
    }

    public TriangleReadingValidationException(String message) {
        super(message);
    }

    public TriangleReadingValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public TriangleReadingValidationException(Throwable cause) {
        super(cause);
    }

    public TriangleReadingValidationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
