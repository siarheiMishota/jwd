package shape.task1.exception;

public class TriangleArgumentException extends IllegalArgumentException {

    public TriangleArgumentException() {
    }

    public TriangleArgumentException(String s) {
        super(s);
    }

    public TriangleArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public TriangleArgumentException(Throwable cause) {
        super(cause);
    }
}
