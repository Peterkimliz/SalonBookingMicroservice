package com.example.barbsalon.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptions {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> userNotFoundException(MethodArgumentNotValidException exception) {
        List<ObjectError> allErrors = exception.getAllErrors();
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        for (ObjectError error : allErrors) {
            exceptionResponse.setMessage(error.getDefaultMessage());
            exceptionResponse.setStatus(HttpStatus.CONFLICT.value());
        }
        System.out.println(allErrors);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ItemNotFound.class)
    public ResponseEntity<ExceptionResponse> itemNotFound(ItemNotFound exception) {
        return new ResponseEntity<>(new ExceptionResponse(
                exception.getMessage(),
                HttpStatus.CONFLICT.value()
        ), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ItemExistsException.class)
    public ResponseEntity<ExceptionResponse> itemExistsException(ItemExistsException exception) {
        return new ResponseEntity<>(new ExceptionResponse(
                exception.getMessage(),
                HttpStatus.CONFLICT.value()
        ), HttpStatus.CONFLICT);
    }

}