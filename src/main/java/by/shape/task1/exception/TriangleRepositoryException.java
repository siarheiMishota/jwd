package by.shape.task1.exception;

public class TriangleRepositoryException extends Exception {

    public TriangleRepositoryException() {
    }

    public TriangleRepositoryException(String message) {
        super(message);
    }

    public TriangleRepositoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public TriangleRepositoryException(Throwable cause) {
        super(cause);
    }
}
