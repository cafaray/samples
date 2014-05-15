package com.ftc.exceptions;

public class FTCServiceException extends Exception {

    public FTCServiceException() {
    }

    public FTCServiceException(String message) {
        super(message);
    }

    public FTCServiceException(Throwable cause) {
        super(cause);
    }

    public FTCServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
