package de.suedleasing.ecsloggingtest;

public class MyRuntimeException extends RuntimeException {
    public MyRuntimeException(String errorMessage) {
        super(errorMessage);
    }
}
