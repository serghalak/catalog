package com.exadel.catalog.exception;

public class DuplicateNameException extends RuntimeException {

    public DuplicateNameException() {
    }

    public DuplicateNameException(String message) {
        super(message);
    }

}