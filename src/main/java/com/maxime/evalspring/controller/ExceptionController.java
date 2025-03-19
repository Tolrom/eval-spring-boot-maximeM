package com.maxime.evalspring.controller;

import com.maxime.evalspring.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Map<String, String>> productNotFound(ProductNotFoundException productNotFound) {
        Map <String, String> errorResponse = new HashMap<>();
        errorResponse.put("Error", productNotFound.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }

    @ExceptionHandler(NoProductFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Map<String, String>> noProducts(NoProductFoundException noProductFound) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("Error", noProductFound.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }

    @ExceptionHandler(ProductAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> productAlreadyExists(ProductAlreadyExistsException productAlreadyExists) {
        Map <String, String> errorResponse = new HashMap<>();
        errorResponse.put("Error", productAlreadyExists.getMessage());
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(errorResponse);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<Map<String, String>> categoryNotFound(CategoryNotFoundException categoryNotFound) {
        Map <String, String> errorResponse = new HashMap<>();
        errorResponse.put("Error", categoryNotFound.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }

    @ExceptionHandler(NoCategoryFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Map<String, String>> noCategories(NoCategoryFoundException noCategoryFound) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("Error", noCategoryFound.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }

    @ExceptionHandler(CategoryAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> categoryAlreadyExists(CategoryAlreadyExistsException categoryAlreadyExists) {
        Map <String, String> errorResponse = new HashMap<>();
        errorResponse.put("Error", categoryAlreadyExists.getMessage());
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(errorResponse);
    }

    @ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>>
    handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(error -> errors.put(error.getField(),
                        error.getDefaultMessage())
                );
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }



}