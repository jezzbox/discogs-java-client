package com.jezzbox.internal.request;

import com.jezzbox.DiscogsClient;
import com.jezzbox.response.ResponseHandler;
import com.jezzbox.response.SingleDiscogsResponse;


public class SingleRequestBuilder<I> extends BaseRequestBuilder<SingleDiscogsResponse<I>> {
    public SingleRequestBuilder(DiscogsClient client, ResponseHandler<SingleDiscogsResponse<I>> responseHandler) {
        super(client, responseHandler);
    }
}
