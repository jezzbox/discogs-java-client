package com.jezzbox.response;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.http.HttpResponse;

public class SingleDiscogsResponse<R> implements DiscogsResponse<R> {
    private final HttpResponse<byte[]> rawResponse;

    private final R content;

    private final String error;

    public SingleDiscogsResponse(R content, HttpResponse<byte[]> rawResponse, String error) {
        this.content = content;
        this.rawResponse = rawResponse;
        this.error = error;
    }
    public R content() {
        return this.content;
    }

    public HttpResponse<byte[]> rawResponse() {
       return this.rawResponse;
    }
}
