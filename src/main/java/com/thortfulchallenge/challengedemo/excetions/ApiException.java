package com.thortfulchallenge.challengedemo.excetions;

public class ApiException extends RuntimeException {

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }
}