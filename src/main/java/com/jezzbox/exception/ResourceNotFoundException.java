package com.jezzbox.exception;


/**
 * This error should be thrown for 404 http errors
 */
public class ResourceNotFoundException extends HttpResponseException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
