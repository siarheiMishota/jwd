package by.shape.task1.exception;

import java.io.IOException;

public class ReadingException extends IOException {
    public ReadingException() {
    }

    public ReadingException(String message) {
        super(message);
    }

    public ReadingException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReadingException(Throwable cause) {
        super(cause);
    }

}
