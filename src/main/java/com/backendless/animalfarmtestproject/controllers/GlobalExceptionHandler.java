package com.backendless.animalfarmtestproject.controllers;

import com.backendless.animalfarmtestproject.exceptions.AnimalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(AnimalException.class)
    public ResponseEntity<String> handleAnimalException(AnimalException e) {
        log.info(e.getErrorMessage());
        return ResponseEntity.ok(e.getErrorMessage());
    }
}
