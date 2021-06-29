package com.nagaty.neotask.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(InvalidWatchIDException.class)
    public ResponseEntity<ExceptionResponse> handleInvalidWatchIDException(InvalidWatchIDException ex){
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode(ex.getResponseCode());
        response.setErrorMessage(ex.getResponseMessage());

        // I returned HTTP status 200 to avoid confusion
        // 404 could be permissible but I think 200 is better
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.OK);
    }

}
