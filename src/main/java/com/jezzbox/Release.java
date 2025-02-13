package com.jezzbox;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.Arrays;
import java.util.Map;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Release {
    private final String artist;

    private final String format;
    private final int id;
    private final String label;
    private final String resourceUrl;
    private final String uri;
    private final Artist[] artists;
    private final String artistsSort;
    private final Label[] labels;
    private final String[] series;
    private final Label[] companies;
    private final ReleaseFormat[] formats;
    private final String dataQuality;
    private final Community community;
    private final int formatQuantity;
    private final String dateAdded;
    private final String dateChanged;
    private final int numForSale;
    private final float lowestPrice;
    private final int masterId;
    private final String masterUrl;
    private final String country;
    private final String released;
    private final String notes;
    private final String releasedFormatted;
    private final Identifier[] identifiers;

    private final Video[] videos;
    private final String[] genres;
    private final String[] styles;
    private final Track[] tracklist;

    private final Artist[] extraartists;
    private final Image[] images;
    private final int estimatedWeight;
    private final boolean blockedFromSale;
    private final Integer mainRelease;
    private final String role;
    private final String status;
    private final String thumb;
    private final String title;
    @JsonProperty("trackinfo") private final String trackInfo;
    private final String type;
    private final int year;
    private final Stats stats;

    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class Community {

        private final Contributor[] contributors;
        private final Contributor submitter;
        private final String dataQuality;
        private final int have;
        private final Rating rating;
        private final String status;
        private final int want;

        public Contributor[] getContributors() {
            return contributors;
        }

        public Contributor getSubmitter() {
            return submitter;
        }

        public String getDataQuality() {
            return dataQuality;
        }

        public int getHave() {
            return have;
        }

        public Rating getRating() {
            return rating;
        }

        public String getStatus() {
            return status;
        }

        public int getWant() {
            return want;
        }

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        public Community(
                @JsonProperty("contributors") Contributor[] contributors,
                @JsonProperty("submitter") Contributor submitter,
                @JsonProperty("data_quality") String dataQuality,
                @JsonProperty("have") int have,
                @JsonProperty("rating") Rating rating,
                @JsonProperty("status") String status,
                @JsonProperty("want") int want
        ) {
            this.contributors = contributors;
            this.submitter = submitter;
            this.dataQuality = dataQuality;
            this.have = have;
            this.rating = rating;
            this.status = status;
            this.want = want;
        }

        @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
        public static class Contributor {
            private final String resourceUrl;
            private final String username;

            @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
            public Contributor(
                    @JsonProperty("resource_url") String resourceUrl,
                    @JsonProperty("username") String username) {
                this.resourceUrl = resourceUrl;
                this.username = username;
            }

            public String getResourceUrl() {
                return resourceUrl;
            }

            public String getUsername() {
                return username;
            }
        }

        @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
        public static class Rating {
            private final float average;
            private final int count;

            @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
            public Rating(
                    @JsonProperty("average") float average,
                    @JsonProperty("count") int count) {
                this.average = average;
                this.count = count;
            }

            public float getAverage() {
                return average;
            }

            public int getCount() {
                return count;
            }
        }

    }

    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class Identifier {
        private final String type;
        private final String value;
        private final String description;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        public Identifier(
                @JsonProperty("type") String type,
                @JsonProperty("value") String value,
                @JsonProperty("description") String description
        ) {
            this.type = type;
            this.value = value;
            this.description = description;
        }

    }

    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class Video {
        private final String uri;
        private final String title;
        private final String description;
        private final int duration;
        private final boolean embed;

        public String getUri() {
            return uri;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public int getDuration() {
            return duration;
        }

        public boolean isEmbed() {
            return embed;
        }

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        public Video(
                @JsonProperty("uri") String uri,
                @JsonProperty("title") String title,
                @JsonProperty("description") String description,
                @JsonProperty("duration") int duration,
                @JsonProperty("embed") boolean embed) {
            this.uri = uri;
            this.title = title;
            this.description = description;
            this.duration = duration;
            this.embed = embed;
        }
    }
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class Track {
        private final String position;
        private final String type_;
        private final String title;
        private final String duration;

        public String getPosition() {
            return position;
        }

        public String getType_() {
            return type_;
        }

        public String getTitle() {
            return title;
        }

        public String getDuration() {
            return duration;
        }

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        public Track(
                @JsonProperty("position") String position,
                @JsonProperty("type_") String type_,
                @JsonProperty("title") String title,
                @JsonProperty("duration") String duration) {
            this.position = position;
            this.type_ = type_;
            this.title = title;
            this.duration = duration;
        }
    }

    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class Image {
        public String getUri() {
            return uri;
        }

        public String getResourceUrl() {
            return resourceUrl;
        }

        public String getUri150() {
            return uri150;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        private final String type;
        private final String uri;
        private final String resourceUrl;
        private final String uri150;
        private final int width;
        private final int height;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        public Image(
                @JsonProperty("type") String type,
                @JsonProperty("uri") String uri,
                @JsonProperty("resource_url") String resourceUrl,
                @JsonProperty("uri150") String uri150,
                @JsonProperty("width") int width,
                @JsonProperty("height") int height
        ) {
            this.type = type;
            this.uri = uri;
            this.resourceUrl = resourceUrl;
            this.uri150 = uri150;
            this.width = width;
            this.height = height;
        }

        public String getType() {
            return type;
        }
    }

    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class Stats {
        private final Map<String, Integer> community;


        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        public Stats(
                @JsonProperty("community") Map<String, Integer> community) {
            this.community = community;
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public Release(
            @JsonProperty("artist") String artist,
            @JsonProperty(value = "id", required = true) int id,
            @JsonProperty("label") String label,
            @JsonProperty("format") String format,
            @JsonProperty("resource_url") String resourceUrl,
            @JsonProperty("uri") String uri,
            @JsonProperty("artists") Artist[] artists,
            @JsonProperty("artists_sort") String artistsSort,
            @JsonProperty("labels") Label[] labels,
            @JsonProperty("series") String[] series,
            @JsonProperty("companies") Label[] companies,
            @JsonProperty("formats") ReleaseFormat[] formats,
            @JsonProperty("data_quality") String dataQuality,
            @JsonProperty("community") Community community,
            @JsonProperty("format_quantity") int formatQuantity,
            @JsonProperty("date_added") String dateAdded,
            @JsonProperty("date_changed") String dateChanged,
            @JsonProperty("num_for_sale") int numForSale,
            @JsonProperty("lowest_price") float lowestPrice,
            @JsonProperty("master_id") int masterId,
            @JsonProperty("master_url") String masterUrl,
            @JsonProperty("country") String country,
            @JsonProperty("released") String released,
            @JsonProperty("notes") String notes,
            @JsonProperty("released_formatted") String releasedFormatted,
            @JsonProperty("identifiers") Identifier[] identifiers,
            @JsonProperty("videos") Video[] videos,
            @JsonProperty("genres") String[] genres,
            @JsonProperty("styles") String[] styles,
            @JsonProperty("tracklist") Track[] tracklist,
            @JsonProperty("extraartists") Artist[] extraartists,
            @JsonProperty("images") Image[] images,
            @JsonProperty("estimated_weight") int estimatedWeight,
            @JsonProperty("blocked_from_sale") boolean blockedFromSale,
            @JsonProperty("main_release") Integer mainRelease,
            @JsonProperty("role") String role,
            @JsonProperty("status") String status,
            @JsonProperty("thumb") String thumb,
            @JsonProperty("title") String title,
            @JsonProperty("trackinfo") String trackInfo,
            @JsonProperty("type") String type,
            @JsonProperty("year") int year,
            @JsonProperty("stats") Stats stats) {
        this.artist = artist;
        this.id = id;
        this.label = label;
        this.format = format;
        this.resourceUrl = resourceUrl;
        this.uri = uri;
        this.artists = artists;
        this.artistsSort = artistsSort;
        this.labels = labels;
        this.series = series;
        this.companies = companies;
        this.formats = formats;
        this.dataQuality = dataQuality;
        this.community = community;
        this.formatQuantity = formatQuantity;
        this.dateAdded = dateAdded;
        this.dateChanged = dateChanged;
        this.numForSale = numForSale;
        this.lowestPrice = lowestPrice;
        this.masterId = masterId;
        this.masterUrl = masterUrl;
        this.country = country;
        this.released = released;
        this.notes = notes;
        this.releasedFormatted = releasedFormatted;
        this.identifiers = identifiers;
        this.videos = videos;
        this.genres = genres;
        this.styles = styles;
        this.tracklist = tracklist;
        this.extraartists = extraartists;
        this.images = images;
        this.estimatedWeight = estimatedWeight;
        this.blockedFromSale = blockedFromSale;
        this.mainRelease = mainRelease;
        this.role = role;
        this.status = status;
        this.thumb = thumb;
        this.title = title;
        this.trackInfo = trackInfo;
        this.type = type;
        this.year = year;
        this.stats = stats;
    }

    public String getArtist() {
        return artist;
    }

    public String getFormat() {
        return format;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public String getUri() {
        return uri;
    }

    public Artist[] getArtists() {
        return artists;
    }

    public String getArtistsSort() {
        return artistsSort;
    }

    public Label[] getLabels() {
        return labels;
    }

    public String[] getSeries() {
        return series;
    }

    public Label[] getCompanies() {
        return companies;
    }

    public ReleaseFormat[] getFormats() {
        return formats;
    }

    public String getDataQuality() {
        return dataQuality;
    }

    public Community getCommunity() {
        return community;
    }

    public int getFormatQuantity() {
        return formatQuantity;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public String getDateChanged() {
        return dateChanged;
    }

    public int getNumForSale() {
        return numForSale;
    }

    public float getLowestPrice() {
        return lowestPrice;
    }

    public int getMasterId() {
        return masterId;
    }

    public String getMasterUrl() {
        return masterUrl;
    }

    public String getCountry() {
        return country;
    }

    public String getReleased() {
        return released;
    }

    public String getNotes() {
        return notes;
    }

    public String getReleasedFormatted() {
        return releasedFormatted;
    }

    public Identifier[] getIdentifiers() {
        return identifiers;
    }

    public Video[] getVideos() {
        return videos;
    }

    public String[] getGenres() {
        return genres;
    }

    public String[] getStyles() {
        return styles;
    }

    public Track[] getTracklist() {
        return tracklist;
    }

    public Artist[] getExtraartists() {
        return extraartists;
    }

    public Image[] getImages() {
        return images;
    }

    public int getEstimatedWeight() {
        return estimatedWeight;
    }

    public boolean isBlockedFromSale() {
        return blockedFromSale;
    }

    public Integer getMainRelease() {
        return mainRelease;
    }

    public String getRole() {
        return role;
    }

    public String getStatus() {
        return status;
    }

    public String getThumb() {
        return thumb;
    }

    public String getTitle() {
        return title;
    }

    public String getTrackInfo() {
        return trackInfo;
    }

    public String getType() {
        return type;
    }

    public int getYear() {
        return year;
    }

    public Stats getStats() {
        return stats;
    }

    @Override
    public String toString() {
        return "Release{" +
                "artist='" + artist + '\'' +
                ", format='" + format + '\'' +
                ", id=" + id +
                ", label='" + label + '\'' +
                ", resourceUrl='" + resourceUrl + '\'' +
                ", uri='" + uri + '\'' +
                ", artists=" + Arrays.toString(artists) +
                ", artistsSort='" + artistsSort + '\'' +
                ", labels=" + Arrays.toString(labels) +
                ", series=" + Arrays.toString(series) +
                ", companies=" + Arrays.toString(companies) +
                ", formats=" + Arrays.toString(formats) +
                ", dataQuality='" + dataQuality + '\'' +
                ", community=" + community +
                ", formatQuantity=" + formatQuantity +
                ", dateAdded='" + dateAdded + '\'' +
                ", dateChanged='" + dateChanged + '\'' +
                ", numForSale=" + numForSale +
                ", lowestPrice=" + lowestPrice +
                ", masterId=" + masterId +
                ", masterUrl='" + masterUrl + '\'' +
                ", country='" + country + '\'' +
                ", released='" + released + '\'' +
                ", notes='" + notes + '\'' +
                ", releasedFormatted='" + releasedFormatted + '\'' +
                ", identifiers=" + Arrays.toString(identifiers) +
                ", videos=" + Arrays.toString(videos) +
                ", genres=" + Arrays.toString(genres) +
                ", styles=" + Arrays.toString(styles) +
                ", tracklist=" + Arrays.toString(tracklist) +
                ", extraartists=" + Arrays.toString(extraartists) +
                ", images=" + Arrays.toString(images) +
                ", estimatedWeight=" + estimatedWeight +
                ", blockedFromSale=" + blockedFromSale +
                ", mainRelease=" + mainRelease +
                ", role='" + role + '\'' +
                ", status='" + status + '\'' +
                ", thumb='" + thumb + '\'' +
                ", title='" + title + '\'' +
                ", trackInfo='" + trackInfo + '\'' +
                ", type='" + type + '\'' +
                ", year=" + year +
                ", stats=" + stats +
                '}';
    }
}

