package shape.task1.exception;

public class TriangleNullPointerException extends RuntimeException{

    public TriangleNullPointerException() {
    }

    public TriangleNullPointerException(String message) {
        super(message);
    }

    public TriangleNullPointerException(String message, Throwable cause) {
        super(message, cause);
    }

    public TriangleNullPointerException(Throwable cause) {
        super(cause);
    }

    public TriangleNullPointerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
