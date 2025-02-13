package com.jezzbox.internal.request;

import com.jezzbox.DiscogsClient;
import com.jezzbox.ReleaseStats;
import com.jezzbox.response.ResponseHandler;

public class GetReleaseStatsBuilder extends SingleRequestBuilder<ReleaseStats> {

    private Integer id;
    public GetReleaseStatsBuilder(DiscogsClient client) {
        super(client, ResponseHandler.forReleaseStats());
    }

    public GetReleaseStatsBuilder id(int id) {
        this.id = id;
        return this;
    }

    public String getPath() {
        return String.format("/releases/%s/stats", this.id);
    }


}
