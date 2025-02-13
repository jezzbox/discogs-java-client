package com.jezzbox.response;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jezzbox.internal.response.PaginatedResponse;

import java.io.IOException;
import java.net.http.HttpResponse;

public class PaginatedResponseHandler<I, P extends PaginatedResponse<I>> implements ResponseHandler<PaginatedDiscogsResponse<I>> {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private final Class<P> clazz;

    public PaginatedResponseHandler(Class<P> clazz) {
        this.clazz = clazz;
    }

    public PaginatedDiscogsResponse<I> fromRawResponse(HttpResponse<byte[]> rawResponse) throws IOException {
        byte[] responseBody = rawResponse.body();
        try {
            P paginatedBody = objectMapper.readValue(responseBody, clazz);
            I[] body = paginatedBody.getContent();
            Pagination pagination1 = paginatedBody.getPagination();
            return new PaginatedDiscogsResponse<>(body, pagination1, rawResponse, null);
        } catch (JsonParseException e) {
            return new PaginatedDiscogsResponse<>(null, null, rawResponse, null);
        }
    }
}
