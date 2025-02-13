package com.jezzbox.request;

public enum SortOrder {
    ASC("asc"),
    DESC("desc");

    private final String name;

    SortOrder(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
