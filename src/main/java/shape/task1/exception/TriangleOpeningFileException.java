package shape.task1.exception;

public class TriangleOpeningFileException extends RuntimeException{

    public TriangleOpeningFileException() {
    }

    public TriangleOpeningFileException(String message) {
        super(message);
    }

    public TriangleOpeningFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public TriangleOpeningFileException(Throwable cause) {
        super(cause);
    }

    public TriangleOpeningFileException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
