package com.jezzbox.exception;

/**
 * This error is for any error that occurs with a http client.
 * The underlying error is passed to the error
 */
public class HttpClientException extends RuntimeException {
    public HttpClientException(String errorMessage, Exception e) {
        super(errorMessage, e);
    }
}
