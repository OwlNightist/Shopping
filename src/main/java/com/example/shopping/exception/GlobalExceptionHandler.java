package com.example.shopping.exception;

import com.example.shopping.model.CustomError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class GlobalExceptionHandler {
    @ExceptionHandler(ShopException.class)
    public ResponseEntity<CustomError> customErrorResponseEntity(ShopException ex){
        return new ResponseEntity<CustomError>(ex.getError(), ex.getStatus());
    }
}
