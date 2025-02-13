package com.jezzbox.internal.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.jezzbox.Release;
import com.jezzbox.response.Pagination;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ReleasesResponse extends PaginatedResponse<Release> {
    private final Release[] releases;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public ReleasesResponse(
            @JsonProperty("pagination") Pagination pagination,
            @JsonProperty("releases") Release[] releases
    ) {
        super(pagination);
        this.releases = releases;
    }
    public Release[] getContent() {
        return releases;
    }
}
