package shape.task1.exception;

public class TriangleValidateException extends RuntimeException{

    public TriangleValidateException() {
    }

    public TriangleValidateException(String message) {
        super(message);
    }

    public TriangleValidateException(String message, Throwable cause) {
        super(message, cause);
    }

    public TriangleValidateException(Throwable cause) {
        super(cause);
    }

    public TriangleValidateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
