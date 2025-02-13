package com.jezzbox.internal.request;

import com.jezzbox.DiscogsClient;
import com.jezzbox.WantlistItem;
import com.jezzbox.internal.response.WantlistResponse;
import com.jezzbox.response.ResponseHandler;

public class GetWantlistBuilder extends PaginatedRequestBuilder<WantlistItem, WantlistResponse> {

    private String username;

    public GetWantlistBuilder(DiscogsClient client) {
        super(client, ResponseHandler.forWantlist());
    }

    public GetWantlistBuilder username(String username) {
        this.username = username;
        return this;
    }

    public String getPath() {
        return String.format("/users/%s/wants", this.username);
    }
}
