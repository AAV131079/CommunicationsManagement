package com.example.CommunicationsManagement.exceptions.handler;

import org.hibernate.PropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@ControllerAdvice
public class DefaultControllerAdvice {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Map> handleException(NoSuchElementException e) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "No such element by id");
        response.put("description", e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PropertyValueException.class)
    public ResponseEntity<Map> handleException(PropertyValueException e) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "PropertyValueException");
        response.put("description", e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}