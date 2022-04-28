package com.hjk.shopboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class ExceptionHandlers {
    
    @ResponseBody
    @ExceptionHandler(value= CustomException.class)
    public ResponseEntity<ErrorDto> exception(CustomException exception){
        return new ResponseEntity<>(ErrorDto.create(exception.getException()), HttpStatus.OK);
    }

    @ExceptionHandler(value= ValidException.class)
    public ResponseEntity<ErrorDto> handleMethodArgumentNotValid(ValidException exception) {
        return new ResponseEntity<>(ErrorDto.create(exception.getException().getAllErrors().get(0).getDefaultMessage()),HttpStatus.OK);
    }



}

