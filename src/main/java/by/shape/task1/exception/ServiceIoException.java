package by.shape.task1.exception;

import java.io.IOException;

public class ServiceIoException extends IOException {

    public ServiceIoException() {
    }

    public ServiceIoException(String message) {
        super(message);
    }

    public ServiceIoException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceIoException(Throwable cause) {
        super(cause);
    }
}
