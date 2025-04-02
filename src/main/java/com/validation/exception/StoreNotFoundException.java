package com.validation.exception;

public class StoreNotFoundException extends RuntimeException {
    public StoreNotFoundException(String localizedMessage) {
        super(localizedMessage);
    }
}
