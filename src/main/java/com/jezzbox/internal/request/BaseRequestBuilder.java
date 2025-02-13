package com.jezzbox.internal.request;

import com.jezzbox.DiscogsClient;
import com.jezzbox.request.DiscogsRequest;
import com.jezzbox.response.ResponseHandler;
import com.jezzbox.response.SingleDiscogsResponse;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public abstract class BaseRequestBuilder<R> {
    private final DiscogsClient client;

    private final ResponseHandler<R> responseHandler;

    public BaseRequestBuilder(DiscogsClient client, ResponseHandler<R> responseHandler) {
        this.client = client;
        this.responseHandler = responseHandler;
    }

    public DiscogsRequest build() {
        return new DiscogsRequest(
                this.getMethod(),
                this.getPath(),
                this.getHeaders(),
                this.getQueryParams(),
                this.getTimeout(),
                this.getPayload()
        );
    }

    public R send() throws URISyntaxException, IOException, InterruptedException {
        return client.send(this.build(), responseHandler);
    }
    String getPath() {
        return "";
    }

    String getPayload() {
        return null;
    }

    String getMethod() {
        return "GET";
    }
    List<Map<String, String>> getHeaders() {
        return Collections.emptyList();
    }

    Duration getTimeout() {
        return null;
    }

    List<Map<String, String>> getQueryParams() {
        return Collections.emptyList();
    }

}
