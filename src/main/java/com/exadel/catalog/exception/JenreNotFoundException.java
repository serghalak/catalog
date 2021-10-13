package com.exadel.catalog.exception;

import javax.persistence.EntityNotFoundException;

public class JenreNotFoundException extends EntityNotFoundException {

    public JenreNotFoundException() {
    }

    public JenreNotFoundException(String message) {
        super(message);
    }
}

