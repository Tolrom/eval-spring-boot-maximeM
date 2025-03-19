package com.maxime.evalspring.exception;

public class CategoryAlreadyExistsException extends RuntimeException {
    public CategoryAlreadyExistsException(String label) {
        super( label + " category already exists in the database");
    }
}
