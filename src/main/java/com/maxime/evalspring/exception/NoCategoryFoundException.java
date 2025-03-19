package com.maxime.evalspring.exception;

public class NoCategoryFoundException extends RuntimeException {
    public NoCategoryFoundException() {
        super("No category found in the database");
    }
}
