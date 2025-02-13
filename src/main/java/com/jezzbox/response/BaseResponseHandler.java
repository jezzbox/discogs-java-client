package com.jezzbox.response;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.http.HttpResponse;

public class BaseResponseHandler<I> implements ResponseHandler<SingleDiscogsResponse<I>> {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private final Class<I> clazz;

    public BaseResponseHandler(Class<I> clazz) {
        this.clazz = clazz;
    }

    public SingleDiscogsResponse<I> fromRawResponse(HttpResponse<byte[]> rawResponse) throws IOException {
        byte[] responseBody = rawResponse.body();
        try {
            I body = objectMapper.readValue(responseBody, clazz);
            return new SingleDiscogsResponse<>(body, rawResponse, null);
        } catch (JsonParseException e) {
            return new SingleDiscogsResponse<>(null, rawResponse, null);
        }
    }
}
