package com.exadel.catalog.exception;

public class RequestArgumentIsNotPresentException extends RuntimeException {

    public RequestArgumentIsNotPresentException() {
    }

    public RequestArgumentIsNotPresentException(String message) {
        super(message);
    }
}
