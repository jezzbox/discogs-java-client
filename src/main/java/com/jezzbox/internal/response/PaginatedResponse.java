package com.jezzbox.internal.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.jezzbox.Release;
import com.jezzbox.response.Pagination;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public abstract class PaginatedResponse<R> {
    private final Pagination pagination;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public PaginatedResponse(
            @JsonProperty("pagination") Pagination pagination
    ) {
        this.pagination = pagination;
    }

    public Pagination getPagination() {
        return pagination;
    }
    public abstract R[] getContent();
}
