package com.exadel.catalog.exception;

import javax.persistence.EntityNotFoundException;

public class PublicationNotFoundException extends EntityNotFoundException {

    public PublicationNotFoundException() {
    }

    public PublicationNotFoundException(String message) {
        super(message);
    }
}

