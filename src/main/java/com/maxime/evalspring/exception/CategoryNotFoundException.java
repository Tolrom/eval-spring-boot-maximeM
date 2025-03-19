package com.maxime.evalspring.exception;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(int id) {
        super("Could not find category with id " + id);
    }
}
