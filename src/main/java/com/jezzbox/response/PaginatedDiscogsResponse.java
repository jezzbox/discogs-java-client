package com.jezzbox.response;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jezzbox.internal.response.PaginatedResponse;

import java.io.IOException;
import java.net.http.HttpResponse;

public class PaginatedDiscogsResponse<R> implements DiscogsResponse<R[]> {
    private final HttpResponse<byte[]> rawResponse;

    private final Pagination pagination;

    private final R[] content;

    private final String error;

    public PaginatedDiscogsResponse(R[] content, Pagination pagination, HttpResponse<byte[]> rawResponse, String error) {
        this.content = content;
        this.pagination = pagination;
        this.rawResponse = rawResponse;
        this.error = error;
    }

    public R[] content() {
        return this.content;
    }

    public HttpResponse<byte[]> rawResponse() {
       return this.rawResponse;
    }

    public byte[] rawBody() {
        return this.rawResponse.body();
    }

}
