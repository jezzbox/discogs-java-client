package com.jezzbox.exception;


/**
 * This error is for any http response from the discogs API that is not successful.
 * extend this error to create a more specific error
 */
public class HttpResponseException extends Exception {

    public HttpResponseException(String message) {
        super(message);
    }
}
