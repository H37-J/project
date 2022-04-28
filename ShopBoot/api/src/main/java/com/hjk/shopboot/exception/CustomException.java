package com.hjk.shopboot.exception;

import lombok.Getter;


public class CustomException extends RuntimeException{

    @Getter
    private final BaseException exception;

    public CustomException(BaseException exception){
        super(exception.getErrorMessage());
        this.exception=exception;
    }



    
}
