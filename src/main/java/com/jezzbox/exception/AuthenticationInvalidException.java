package com.jezzbox.exception;


/**
 * This error is for 401 or 403 http errors
 */
public class AuthenticationInvalidException extends HttpResponseException {

    public AuthenticationInvalidException(String message) {
        super(message);
    }
}
