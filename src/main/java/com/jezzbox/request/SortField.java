package com.jezzbox.request;

public enum SortField {

    YEAR("year"),
    TITLE("title"),
    FORMAT("format");

    private final String name;
    SortField(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
