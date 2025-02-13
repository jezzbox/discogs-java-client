package com.jezzbox.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.Map;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Pagination {
    private final int page;
    private final int pages;
    private final int perPage;
    private final int items;
    private final Urls urls;

    public int getPage() {
        return page;
    }

    public int getPages() {
        return pages;
    }

    public int getPerPage() {
        return perPage;
    }

    public int getItems() {
        return items;
    }

    public Urls getUrls() {
        return urls;
    }

    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class Urls {
        private final String first;
        private final String last;
        private final String prev;
        private final String next;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        public Urls(
                @JsonProperty("first") String first,
                @JsonProperty("last") String last,
                @JsonProperty("prev") String prev,
                @JsonProperty("next") String next
        ) {
            this.first = first;
            this.last = last;
            this.prev = prev;
            this.next = next;
        }

        public String getFirst() {
            return first;
        }

        public String getLast() {
            return last;
        }

        public String getPrev() {
            return prev;
        }

        public String getNext() {
            return next;
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public Pagination(
            @JsonProperty("page") int page,
            @JsonProperty("pages") int pages,
            @JsonProperty("per_page") int perPage,
            @JsonProperty("items") int items,
            @JsonProperty("urls") Urls urls
    ) {
        this.page = page;
        this.pages = pages;
        this.perPage = perPage;
        this.items = items;
        this.urls = urls;
    }


}

