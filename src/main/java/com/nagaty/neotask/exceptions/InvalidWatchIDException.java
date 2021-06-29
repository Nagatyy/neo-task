package com.nagaty.neotask.exceptions;

public class InvalidWatchIDException extends RuntimeException{
    private final String responseMessage;
    private final int responseCode;

    public InvalidWatchIDException() {
        responseMessage = "An invalid watch ID was found";
        responseCode = 404;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public int getResponseCode() {
        return responseCode;
    }
}
