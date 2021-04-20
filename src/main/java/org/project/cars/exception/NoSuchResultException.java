package org.project.cars.exception;

public class NoSuchResultException extends RuntimeException{

    public NoSuchResultException(String message) {
        super(message);
    }

    public NoSuchResultException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchResultException(Throwable cause) {
        super(cause);
    }
}
