package com.jezzbox.exception;


/**
 * This error is for 422 http errors
 */
public class InvalidRequestParametersException extends HttpResponseException {
    public InvalidRequestParametersException(String message) {
        super(message);
    }
}
