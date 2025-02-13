package com.jezzbox.internal.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.jezzbox.Release;
import com.jezzbox.WantlistItem;
import com.jezzbox.response.Pagination;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class WantlistResponse extends PaginatedResponse<WantlistItem> {
    private final WantlistItem[] wants;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public WantlistResponse(
            @JsonProperty("pagination") Pagination pagination,
            @JsonProperty("wants") WantlistItem[] wants
    ) {
        super(pagination);
        this.wants = wants;
    }
    public WantlistItem[] getContent() {
        return wants;
    }
}
