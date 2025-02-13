package com.jezzbox;

import com.jezzbox.internal.ReleaseService;
import com.jezzbox.internal.UserService;
import com.jezzbox.internal.response.PaginatedResponse;
import com.jezzbox.request.DiscogsRequest;
import com.jezzbox.response.DiscogsResponse;
import com.jezzbox.response.PaginatedDiscogsResponse;
import com.jezzbox.response.ResponseHandler;
import com.jezzbox.response.SingleDiscogsResponse;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

public class DiscogsClient {
    public static final String HOST = "https://api.discogs.com";
    private final HttpClient httpClient;
    private final ClientConfiguration configuration;

    private DiscogsClient(HttpClient httpClient, ClientConfiguration configuration) {
        this.httpClient = httpClient;
        this.configuration = configuration;
    }
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Returns a new com.jezzbox.DiscogsClient with default settings.
     * @return a new com.jezzbox.DiscogsClient
     */
    public static DiscogsClient newDiscogsClient() {
        return DiscogsClient.builder().build();
    }

    public static class Builder {
        private HttpClient httpClient;
        private ClientConfiguration configuration;

        private Builder() {
        }

        public Builder httpClient(HttpClient httpClient) {
            this.httpClient = httpClient;
            return this;
        }

        public Builder configuration(ClientConfiguration clientConfiguration) {
            this.configuration = clientConfiguration;
            return this;
        }
        public Builder configuration(Function<ClientConfiguration.Builder, ClientConfiguration.Builder> configSupplier) {
            ClientConfiguration.Builder configurationBuilder = ClientConfiguration.builder();
            configSupplier.apply(configurationBuilder);
            this.configuration = configurationBuilder.build();
            return this;
        }

        public DiscogsClient build() {
            return new DiscogsClient(
                    Objects.nonNull(httpClient) ? httpClient : HttpClient.newHttpClient(),
                    configuration
            );
        }
    }

    public ReleaseService releases() {
        return new ReleaseService(this);
    }
    public UserService users() {
        return new UserService(this);
    }

    public HttpRequest buildRequest(DiscogsRequest request) throws URISyntaxException {
        HttpRequest.BodyPublisher bodyPublisher;
        List<String> headers = new ArrayList<>();
        for (Map<String, String> headersMap : request.getHeaders()) {
            for (var entry : headersMap.entrySet()) {
                headers.add(entry.getKey());
                headers.add(entry.getValue());
            }
        }

        //add authorization header
        if (Objects.nonNull(this.configuration.token)) {
            headers.add("Authorization");
            headers.add(String.format("Discogs token=%s", this.configuration.token));
        } else if (Objects.nonNull(this.configuration.key) && Objects.nonNull(this.configuration.secret)) {
            headers.add("Authorization");
            headers.add(String.format("Discogs key=%s secret=%s", this.configuration.key, this.configuration.secret));
        }

        String path = request.getUri();
        if (!request.getQueryParams().isEmpty()) {
            List<String> params = new ArrayList<>();
            for (Map<String, String> param : request.getQueryParams()) {
                for (var entry : param.entrySet()) {
                    String val = String.format("%s=%s", entry.getKey(), URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8));
                    params.add(val);
                }
            }
            path = path + "?" + String.join("&", params);
        }

        if (request.getBody() != null ) {
            bodyPublisher = HttpRequest.BodyPublishers.ofString(request.getBody());
        } else {
            bodyPublisher = HttpRequest.BodyPublishers.noBody();
        }
        URI uri = new URI(HOST + path);
        String[] finalHeaders = headers.toArray(new String[0]);
        HttpRequest.Builder builder = HttpRequest.newBuilder()
                .uri(uri)
                .headers(finalHeaders)
                .method(request.getMethod(), bodyPublisher);

        // set timeout if specified
        if (Objects.nonNull(request.getTimeout())) {
            builder = builder.timeout(request.getTimeout());
        }
        return builder.build();
    }

    public <R> R send(DiscogsRequest request, ResponseHandler<R> responseHandler) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest httpRequest = this.buildRequest(request);
        HttpResponse<byte[]> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofByteArray());
        return responseHandler.fromRawResponse(httpResponse);
    }
}
