package com.jezzbox.request;

public class PaginationOptions {
    protected final Integer perPage;
    protected final Integer page;
    protected final SortField sortField;
    protected final SortOrder sortOrder;

    public static Builder builder() {
        return new Builder();
    }

    public Integer getPerPage() {
        return perPage;
    }

    public Integer getPage() {
        return page;
    }

    public SortField getSortField() {
        return sortField;
    }

    public SortOrder getSortOrder() {
        return sortOrder;
    }

    private PaginationOptions(
            Integer perPage,
            Integer page,
            SortField sortField,
            SortOrder sortOrder
    ) {
        this.perPage = perPage;
        this.page = page;
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }

    public static PaginationOptions emptyPaginationOptions() {
        return new PaginationOptions(null, null, null, null);
    }

    public static class Builder {
        private Integer perPage;
        private Integer page;
        private SortField sortField;
        private SortOrder sortOrder;

        private Builder() {}

        public PaginationOptions build() {
            return new PaginationOptions(
                    perPage,
                    page,
                    sortField,
                    sortOrder
            );
        }
        public Builder perPage(int perPage) {
            this.perPage = perPage;
            return this;
        }

        public Builder page(int page) {
            this.page = page;
            return this;
        }

        public Builder sortBy(SortField sortField) {
            this.sortField = sortField;
            return this;
        }
        public Builder sortOrder(SortOrder sortOrder) {
            this.sortOrder = sortOrder;
            return this;
        }
    }
}
