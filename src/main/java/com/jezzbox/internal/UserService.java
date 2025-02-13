package com.jezzbox.internal;

import com.jezzbox.DiscogsClient;
import com.jezzbox.internal.request.GetReleaseBuilder;
import com.jezzbox.internal.request.GetReleaseStatsBuilder;
import com.jezzbox.internal.request.GetWantlistBuilder;

public class UserService extends DiscogsService {
    private final static String RESOURCE_NAME = "users";
    public UserService(DiscogsClient client) {
        super(client, RESOURCE_NAME);
    }

    public GetWantlistBuilder readWantlist() {
        return new GetWantlistBuilder(this.client);
    }
}
