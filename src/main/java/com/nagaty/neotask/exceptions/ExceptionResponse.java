package com.nagaty.neotask.exceptions;

public class ExceptionResponse {
    private String errorMessage;
    private int errorCode;

    public String getErrorMessage() {
        return errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}