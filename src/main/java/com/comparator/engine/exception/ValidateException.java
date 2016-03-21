package com.comparator.engine.exception;

/**
 * Created by Retman on 2016-03-07.
 */
public class ValidateException extends Exception {
    private String message;

    public ValidateException(String message) {
        this.message = message;
        System.out.println(getMessage());
    }

    @Override
    public String getMessage() {
        return message;
    }
}
