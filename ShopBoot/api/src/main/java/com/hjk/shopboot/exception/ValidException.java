package com.hjk.shopboot.exception;

import lombok.Getter;
import org.springframework.validation.BindingResult;


public class ValidException extends RuntimeException {

    @Getter
    private final BindingResult exception;

    public ValidException(BindingResult exception) {
        super(exception.getAllErrors().get(0).getDefaultMessage());
        this.exception = exception;
    }
}