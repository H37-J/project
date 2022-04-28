package com.hjk.shopboot.exception;

public interface BaseException {
    int getErrorCode();
    int getHttpStatus();
    String getErrorMessage();
}
