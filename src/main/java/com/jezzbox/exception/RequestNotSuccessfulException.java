package com.jezzbox.exception;

/**
 * This error is for 400 http errors
 */
public class RequestNotSuccessfulException extends HttpResponseException {
    public RequestNotSuccessfulException(String message) {
        super(message);
    }
}
