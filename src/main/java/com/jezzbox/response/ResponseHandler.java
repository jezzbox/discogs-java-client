package com.jezzbox.response;

import com.jezzbox.Release;
import com.jezzbox.ReleaseStats;
import com.jezzbox.WantlistItem;
import com.jezzbox.internal.response.ReleasesResponse;
import com.jezzbox.internal.response.WantlistResponse;

import java.io.IOException;
import java.net.http.HttpResponse;

public interface ResponseHandler<R> {
    R fromRawResponse(HttpResponse<byte[]> rawResponse) throws IOException;

    static PaginatedResponseHandler<Release, ReleasesResponse> forReleases() {
        return new PaginatedResponseHandler<>(ReleasesResponse.class);
    }
    static BaseResponseHandler<Release> forRelease() {
        return new BaseResponseHandler<>(Release.class);
    }
    static BaseResponseHandler<ReleaseStats> forReleaseStats() {
        return new BaseResponseHandler<>(ReleaseStats.class);
    }
    static PaginatedResponseHandler<WantlistItem, WantlistResponse> forWantlist() {
        return new PaginatedResponseHandler<>(WantlistResponse.class);
    }
}
