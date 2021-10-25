package com.exadel.catalog.exception;

public class TitleIsNotPresentException extends RuntimeException{

    public TitleIsNotPresentException() {
    }

    public TitleIsNotPresentException(String message) {
        super(message);
    }
}
