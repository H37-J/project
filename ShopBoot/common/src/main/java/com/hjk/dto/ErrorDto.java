//package com.hjk.dto;
//
//import lombok.*;
//
//@Getter
//@Setter
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//public class ErrorDto {
//
//    private int code;
//    private int status;
//    private String message;
//
//    public ErrorDto(String message){
//        this.message=message;
//    }
//
//    public static ErrorDto create(String message){
//        return new ErrorDto(message);
//    }
//
//    public static ErrorDto create(BaseException baseException){
//        return new ErrorDto(baseException.getErrorCode(),baseException.getHttpStatus(),baseException.getErrorMessage());
//    }
//
//}
