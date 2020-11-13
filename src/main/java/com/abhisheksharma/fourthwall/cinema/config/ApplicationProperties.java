package com.abhisheksharma.fourthwall.cinema.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Properties specific to this application.
 * <p>
 * Properties are configured in the {@code application.yml} file.
 */
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {

    private OMDBProp omdbProp   =   new OMDBProp();

    public OMDBProp getOMDBProp(){ return omdbProp;}

    public static class OMDBProp {
        private String url;
        private String apiKey;

        public String getUrl() { return url; }

        public void setUrl(String url) { this.url = url; }

        public String getApiKey() { return apiKey; }

        public void setApiKey(String apiKey) { this.apiKey = apiKey; }
    }
}
