package com.backendless.animalfarmtestproject.controllers;

import com.backendless.animalfarmtestproject.exceptions.AnimalException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AnimalException.class)
    public ResponseEntity<String> handleAnimalException(AnimalException e) {
        return ResponseEntity.ok(e.getErrorMessage());
    }
}
