package com.jezzbox;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ReleaseFormat {

    private final String name;
    private final String qty;
    private final String[] descriptions;
    private final String text;

    @JsonCreator(mode= JsonCreator.Mode.PROPERTIES)
    public ReleaseFormat(
        @JsonProperty("name") String name,
        @JsonProperty("qty") String qty,
        @JsonProperty("descriptions") String[] descriptions,
        @JsonProperty("text") String text) {
        this.name = name;
        this.qty = qty;
        this.descriptions = descriptions;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public String getQty() {
        return qty;
    }

    public String[] getDescriptions() {
        return descriptions;
    }

    public String getText() {
        return text;
    }
}

