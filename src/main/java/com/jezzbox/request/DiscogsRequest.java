package com.jezzbox.request;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class DiscogsRequest {
    private final String method;
    private final String path;
    private final List<Map<String, String>> headers;
    private final List<Map<String, String>> queryParams;
    private final Duration timeout;
    private final String body;

    public DiscogsRequest(
            String method,
            String path,
            List<Map<String, String>> headers,
            List<Map<String, String>> queryParams,
            Duration timeout,
            String body
    ) {
        this.method = method;
        this.path = path;
        this.headers = headers;
        this.queryParams = queryParams;
        this.timeout = timeout;
        this.body = body;
    }

    public String getMethod() {
        return this.method;
    }

    public String getUri() {
        return this.path;
    }
    public List<Map<String, String>> getHeaders() {
        return this.headers;
    }

    public String getBody() {
        return this.body;
    }

    public Duration getTimeout() {
        return this.timeout;
    }

    public List<Map<String, String>> getQueryParams() {
        return this.queryParams;
    }
}
