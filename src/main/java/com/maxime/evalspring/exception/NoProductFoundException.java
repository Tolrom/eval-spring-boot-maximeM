package com.maxime.evalspring.exception;

public class NoProductFoundException extends RuntimeException {
    public NoProductFoundException() {
        super("No product found in the database");
    }
}
