package com.jezzbox.internal.request;

import com.jezzbox.DiscogsClient;
import com.jezzbox.MarketPlaceCurrency;
import com.jezzbox.Release;
import com.jezzbox.internal.response.ReleasesResponse;
import com.jezzbox.response.DiscogsResponse;
import com.jezzbox.response.ResponseHandler;
import com.jezzbox.response.SingleDiscogsResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class GetReleaseBuilder extends SingleRequestBuilder<Release> {
    private final Integer id;
    protected MarketPlaceCurrency currency;

    private GetReleaseBuilder(DiscogsClient client, Integer id) {
        super(client, ResponseHandler.forRelease());
        this.id = id;
    }

    public static RootBuilder builder(DiscogsClient client) {
        return new RootBuilder(client);
    }

    public static class RootBuilder {
        private final DiscogsClient client;
        private RootBuilder(DiscogsClient client) {
            this.client = client;
        }

        public GetReleasesBuilder artistId(int artistId) {
            GetReleaseBuilder baseBuilder = new GetReleaseBuilder(client, null);
            return new GetReleasesBuilder(client, baseBuilder, artistId, null);
        }

        public GetReleasesBuilder labelId(int labelId) {
            GetReleaseBuilder baseBuilder = new GetReleaseBuilder(client, null);
            return new GetReleasesBuilder(client, baseBuilder, null, labelId);
        }

        public GetReleaseBuilder id(int id) {
            return new GetReleaseBuilder(client, id);
        }
    }

    public static class GetReleasesBuilder extends PaginatedRequestBuilder<Release, ReleasesResponse> {
        private final GetReleaseBuilder releaseBuilder;
        protected Integer artistId;
        protected Integer labelId;

        private GetReleasesBuilder(
                DiscogsClient client,
                com.jezzbox.internal.request.GetReleaseBuilder baseBuilder,
                Integer artistId,
                Integer labelId
        ) {
            super(client, ResponseHandler.forReleases());
            this.releaseBuilder = baseBuilder;
            this.artistId = artistId;
            this.labelId = labelId;
        }

        public GetReleasesBuilder currency(MarketPlaceCurrency currency) {
            this.releaseBuilder.currency = currency;
            return this;
        }

        public List<Map<String, String>> getQueryParams() {
            List<Map<String, String>> queryParams = new ArrayList<>(super.getQueryParams());
            queryParams.addAll(releaseBuilder.getQueryParams());
            return queryParams;
        }

        public String getPath() {
            if (Objects.nonNull(this.artistId)) {
                return String.format("/artists/%s/releases", this.artistId);
            }
            if (Objects.nonNull(this.labelId)) {
                return String.format("/labels/%s/releases", this.labelId);
            }
            return null;
        }


    }
    public GetReleaseBuilder currency(MarketPlaceCurrency currency) {
        this.currency = currency;
        return this;
    }

    public List<Map<String, String>> getQueryParams() {
        List<Map<String, String>> queryParams = new ArrayList<>(super.getQueryParams());
        if (Objects.nonNull(currency)) {
            queryParams.add(Map.of("curr_abbr", String.valueOf(currency)));
        }
        return queryParams;
    }
    public String getPath() {
        if (Objects.nonNull(this.id)) {
            return String.format("/releases/%s", this.id);
        }
        return null;
    }
}
