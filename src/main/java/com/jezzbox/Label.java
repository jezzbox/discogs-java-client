package com.jezzbox;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Label {
    private final String name;
    private final String catno;
    private final String entityType;
    private final String entityTypeName;
    private final int id;
    private final String resourceUrl;
    private final String thumbnailUrl;

    public String getName() {
        return name;
    }

    public String getCatno() {
        return catno;
    }

    public String getEntityType() {
        return entityType;
    }

    public String getEntityTypeName() {
        return entityTypeName;
    }

    public int getId() {
        return id;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    @JsonCreator(mode= JsonCreator.Mode.PROPERTIES)
    public Label(
        @JsonProperty("name") String name,
        @JsonProperty("catno") String catno,
        @JsonProperty("entity_type") String entityType,
        @JsonProperty("entity_type_name") String entityTypeName,
        @JsonProperty("id") int id,
        @JsonProperty("resource_url") String resourceUrl,
        @JsonProperty("thumbnail_url") String thumbnailUrl
    ) {
        this.name = name;
        this.catno = catno;
        this.entityType = entityType;
        this.entityTypeName = entityTypeName;
        this.id = id;
        this.resourceUrl = resourceUrl;
        this.thumbnailUrl = thumbnailUrl;
    }


    public String getThumbnailUrl() {
        return thumbnailUrl;
    }
}
