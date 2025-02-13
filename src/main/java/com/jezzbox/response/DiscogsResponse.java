package com.jezzbox.response;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jezzbox.internal.response.PaginatedResponse;

import java.io.IOException;
import java.net.http.HttpResponse;

public interface DiscogsResponse<R> {
    HttpResponse<byte[]> rawResponse();
    default int statusCode() {
        return this.rawResponse().statusCode();
    }
    R content();

    default byte[] rawBody() {
        return this.rawResponse().body();
    }
}
