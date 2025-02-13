package com.jezzbox;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class WantlistItem {

    private final int id;
    private final String resourceUrl;
    private final String dateAdded;
    private final BasicInformation basicInformation;
    private final int rating;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public WantlistItem(
            @JsonProperty("id") int id,
            @JsonProperty("resource_url") String resourceUrl,
            @JsonProperty("date_added") String dateAdded,
            @JsonProperty("basic_information") BasicInformation basicInformation,
            @JsonProperty("rating") int rating
    ) {
        this.id = id;
        this.resourceUrl = resourceUrl;
        this.dateAdded = dateAdded;
        this.basicInformation = basicInformation;
        this.rating = rating;
    }

    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class BasicInformation {
        @JsonProperty("id") private final int id;
        @JsonProperty("master_id") private final int masterId;
        @JsonProperty("master_url") private final String masterUrl;
        @JsonProperty("resource_url") private final String resourceUrl;
        @JsonProperty("title") private final String title;
        @JsonProperty("year") private final int year;
        @JsonProperty("formats") private final List<ReleaseFormat> formats;
        @JsonProperty("artists") private final List<Artist> artists;
        @JsonProperty("labels") private final List<Label> labels;
        @JsonProperty("thumb") private final String thumb;
        @JsonProperty("cover_image") private final String coverImage;
        @JsonProperty("genres") private final List<String> genres;
        @JsonProperty("styles") private final List<String> styles;

        @JsonCreator(mode= JsonCreator.Mode.PROPERTIES)
        public BasicInformation(
                @JsonProperty("id") int id,
                @JsonProperty("master_id") int masterId,
                @JsonProperty("master_url") String masterUrl,
                @JsonProperty("resource_url") String resourceUrl,
                @JsonProperty("title") String title,
                @JsonProperty("year") int year,
                @JsonProperty("formats") List<ReleaseFormat> formats,
                @JsonProperty("artists") List<Artist> artists,
                @JsonProperty("labels") List<Label> labels,
                @JsonProperty("thumb") String thumb,
                @JsonProperty("cover_image") String coverImage,
                @JsonProperty("genres") List<String> genres,
                @JsonProperty("styles") List<String> styles
        ) {
            this.id = id;
            this.masterId = masterId;
            this.masterUrl = masterUrl;
            this.resourceUrl = resourceUrl;
            this.title = title;
            this.year = year;
            this.formats = formats;
            this.artists = artists;
            this.labels = labels;
            this.thumb = thumb;
            this.coverImage = coverImage;
            this.genres = genres;
            this.styles = styles;
        }

        @Override
        public String toString() {
            return "BasicInformation{" +
                    "id=" + id +
                    ", masterId=" + masterId +
                    ", masterUrl='" + masterUrl + '\'' +
                    ", resourceUrl='" + resourceUrl + '\'' +
                    ", title='" + title + '\'' +
                    ", year=" + year +
                    ", formats=" + formats +
                    ", artists=" + artists +
                    ", labels=" + labels +
                    ", thumb='" + thumb + '\'' +
                    ", coverImage='" + coverImage + '\'' +
                    ", genres=" + genres +
                    ", styles=" + styles +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "WantlistItem{" +
                "id=" + id +
                ", resourceUrl='" + resourceUrl + '\'' +
                ", dateAdded='" + dateAdded + '\'' +
                ", basicInformation=" + basicInformation +
                ", rating=" + rating +
                '}';
    }
}
