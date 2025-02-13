package com.jezzbox.internal.request;

import com.jezzbox.DiscogsClient;
import com.jezzbox.internal.response.PaginatedResponse;
import com.jezzbox.request.PaginationOptions;
import com.jezzbox.response.PaginatedDiscogsResponse;
import com.jezzbox.response.PaginatedResponseHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

public class PaginatedRequestBuilder<I, P extends PaginatedResponse<I>> extends BaseRequestBuilder<PaginatedDiscogsResponse<I>> {
    private PaginationOptions paginationOptions;

    public PaginatedRequestBuilder(DiscogsClient client, PaginatedResponseHandler<I, P> responseHandler) {
        super(client, responseHandler);
        this.paginationOptions = PaginationOptions.emptyPaginationOptions();
    }

    public PaginatedRequestBuilder<I, P> pagination(Function<PaginationOptions.Builder, PaginationOptions.Builder> paginationOptions) {
        PaginationOptions.Builder builder = PaginationOptions.builder();
        paginationOptions.apply(builder);
        return this.pagination(builder.build());
    }
    public PaginatedRequestBuilder<I, P> pagination(PaginationOptions paginationOptions) {
        this.paginationOptions = paginationOptions;
        return this;
    }
    protected List<Map<String, String>> getQueryParams() {
        List<Map<String, String>> queryParams = new ArrayList<>(super.getQueryParams());
        if (Objects.nonNull(this.paginationOptions.getPage())) {
            queryParams.add(Map.of("per_page", String.valueOf(this.paginationOptions.getPerPage())));
        }
        if (Objects.nonNull(this.paginationOptions.getPage())) {
            queryParams.add(Map.of("page", String.valueOf(this.paginationOptions.getPage())));
        }
        if (Objects.nonNull(this.paginationOptions.getSortField())) {
            queryParams.add(Map.of("sort", String.valueOf(this.paginationOptions.getSortField())));
        }
        if (Objects.nonNull(this.paginationOptions.getSortOrder())) {
            queryParams.add(Map.of("sort_by", String.valueOf(this.paginationOptions.getSortOrder())));
        }
        return queryParams;
    }
}
