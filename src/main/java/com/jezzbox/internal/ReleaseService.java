package com.jezzbox.internal;

import com.jezzbox.DiscogsClient;
import com.jezzbox.internal.request.GetReleaseBuilder;
import com.jezzbox.internal.request.GetReleaseStatsBuilder;

public class ReleaseService extends DiscogsService {
    private final static String RESOURCE_NAME = "releases";
    public ReleaseService(DiscogsClient client) {
        super(client, RESOURCE_NAME);
    }

    public GetReleaseBuilder.RootBuilder read() {
        return GetReleaseBuilder.builder(this.client);
    }

    public GetReleaseStatsBuilder getStats() {
        return new GetReleaseStatsBuilder(this.client);
    }
}
