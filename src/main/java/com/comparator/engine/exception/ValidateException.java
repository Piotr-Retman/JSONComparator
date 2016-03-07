package com.comparator.engine.exception;

/**
 * Created by Retman on 2016-03-07.
 */
public class ValidateException extends Exception {
    private String message;
    private int errorNumber;

    public ValidateException(String message,int errorNumber){
        this.errorNumber = errorNumber;
        this.message = message;
        System.out.println(getMessage());
    }

    @Override
    public String getMessage() {
        return errorNumber + " " + message;
    }
}
