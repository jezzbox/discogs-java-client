package com.jezzbox;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ReleaseStats {
    private final String numForSale;
    private final LowestPrice lowestPrice;
    private final boolean blockedFromSale;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public ReleaseStats(
            @JsonProperty("num_for_sale") String numForSale,
            @JsonProperty("lowest_price") LowestPrice lowestPrice,
            @JsonProperty("blocked_from_sale") boolean blockedFromSale) {
        this.numForSale = numForSale;
        this.lowestPrice = lowestPrice;
        this.blockedFromSale = blockedFromSale;
    }

    public String getNumForSale() {
        return numForSale;
    }

    public LowestPrice getLowestPrice() {
        return lowestPrice;
    }

    public boolean isBlockedFromSale() {
        return blockedFromSale;
    }

    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class LowestPrice {
        private final float value;
        private final String currency;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        public LowestPrice(
                @JsonProperty("value") float value,
                @JsonProperty("currency") String currency) {
            this.value = value;
            this.currency = currency;
        }

        public float getValue() {
            return value;
        }

        public String getCurrency() {
            return currency;
        }
    }
}

