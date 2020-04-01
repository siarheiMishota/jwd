package shape.task1.exception;

import java.io.IOException;

public class DaoIOException extends IOException {
    public DaoIOException() {
    }

    public DaoIOException(String message) {
        super(message);
    }

    public DaoIOException(String message, Throwable cause) {
        super(message, cause);
    }

    public DaoIOException(Throwable cause) {
        super(cause);
    }

}
