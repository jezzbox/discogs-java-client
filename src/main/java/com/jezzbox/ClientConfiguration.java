package com.jezzbox;

public class ClientConfiguration {
    public static final String HOST = "https://api.discogs.com";
    protected final String key;
    protected final String secret;
    protected final String token;
    protected final String userAgent;

    private ClientConfiguration(String key, String secret, String token, String userAgent) {
        this.key = key;
        this.secret = secret;
        this.token = token;
        this.userAgent = userAgent;
    }

    public static Builder builder() {
       return new Builder();
    }

    public static class Builder {
        private String key;
        private String secret;
        private String token;
        private String userAgent;

        private Builder() {}

        public ClientConfiguration build() {
            return new ClientConfiguration(
                    this.key,
                    this.secret,
                    this.token,
                    this.userAgent
            );
        }

        public Builder key(String key) {
            this.key = key;
            return this;
        }

        public Builder secret(String secret) {
            this.secret = secret;
            return this;
        }
        public Builder token(String token) {
            this.token = token;
            return this;
        }
        public Builder userAgent(String userAgent) {
            this.userAgent = userAgent;
            return this;
        }
    }
}
