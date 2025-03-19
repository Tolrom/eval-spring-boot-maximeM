package com.maxime.evalspring.exception;

public class ProductAlreadyExistsException extends RuntimeException {
    public ProductAlreadyExistsException(String name) {
        super( name + " already exists in the database");
    }
}
