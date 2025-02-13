package com.jezzbox;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Artist {
    private final String name;
    private final String anv;
    private final String join;
    private final String role;
    private final String tracks;
    private final int id;
    private final String resourceUrl;

    public String getName() {
        return name;
    }

    public String getAnv() {
        return anv;
    }

    public String getJoin() {
        return join;
    }

    public String getRole() {
        return role;
    }

    public String getTracks() {
        return tracks;
    }

    public int getId() {
        return id;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    private final String thumbnailUrl;

    @JsonCreator(mode= JsonCreator.Mode.PROPERTIES)
    public Artist(
            @JsonProperty("name") String name,
            @JsonProperty("anv") String anv,
            @JsonProperty("join") String join,
            @JsonProperty("role") String role,
            @JsonProperty("tracks") String tracks,
            @JsonProperty("id") int id,
            @JsonProperty("resource_url") String resourceUrl,
            @JsonProperty("thumbnail_url") String thumbnailUrl
            ) {
        this.name = name;
        this.anv = anv;
        this.join = join;
        this.role = role;
        this.tracks = tracks;
        this.id = id;
        this.resourceUrl = resourceUrl;
        this.thumbnailUrl = thumbnailUrl;
    }
}

