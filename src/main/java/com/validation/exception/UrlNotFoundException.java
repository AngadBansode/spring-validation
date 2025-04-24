package com.validation.exception;

public class UrlNotFoundException extends RuntimeException {
    public UrlNotFoundException(String s) {
        super(s);
    }
}
