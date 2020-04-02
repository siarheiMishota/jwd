package by.shape.task1.exception;

public class DaoTriangleException extends RuntimeException {

    public DaoTriangleException() {
    }

    public DaoTriangleException(String message) {
        super(message);
    }

    public DaoTriangleException(String message, Throwable cause) {
        super(message, cause);
    }

    public DaoTriangleException(Throwable cause) {
        super(cause);
    }

    public DaoTriangleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
