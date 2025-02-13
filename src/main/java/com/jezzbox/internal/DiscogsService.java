package com.jezzbox.internal;

import com.jezzbox.DiscogsClient;

abstract class DiscogsService {
    protected final DiscogsClient client;
    protected final String resourceName;

    public DiscogsService(DiscogsClient client, String resourceName) {
        this.client = client;
        this.resourceName = resourceName;
    }
    public String getResourceName() {
        return this.resourceName;
    };
}
