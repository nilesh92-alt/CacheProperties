package com.example.test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleEmployeeNotFoundException(Exception ex) {

        ApiError apiError = new ApiError("Employee is not found by empId : " + ex.getMessage(), HttpStatus.NOT_FOUND);

        return new ResponseEntity(apiError, apiError.getStatusCode());

    }

}
