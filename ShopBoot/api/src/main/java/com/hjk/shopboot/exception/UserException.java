package com.hjk.shopboot.exception;

import lombok.Getter;

@Getter
public enum UserException implements BaseException {

    NOT_FOUND_USER(1001,200,"해당하는 사용자가 존재하지 않습니다."),
    DUPLICATED_USER(1002, 200, "이미 존재하는 사용자 아이디입니다."),
    WRONG_PASSWORD(1003, 200, "패스워드를 잘못 입력하였습니다."),
    LOGIN_INFORMATION_NOT_FOUND(1004, 200, "로그인 해주세요."),
    PASS_CHECK(1005,200,"패스워드가 일치하지 않습니다"),
    DUPLICATED_NICKNAME(1006, 200, "이미 존재하는 닉네임입니다."),
    DUPLICATED_EMAIL(1007, 200, "이미 존재 이메일입니다."),
    IS_HUMAN(1008, 200,"이 계정은 휴면 계정입니다.");
 

    private final int errorCode;
    private final int httpStatus;
    private final String errorMessage;

    UserException(int errorCode, int httpStatus, String errorMessage){
        this.errorCode=errorCode;
        this.httpStatus=httpStatus;
        this.errorMessage=errorMessage;
    }

    
    
}
