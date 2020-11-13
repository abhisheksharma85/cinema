package com.abhisheksharma.fourthwall.cinema.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OMDBRating {

    @JsonProperty("Source")
    private String source;

    @JsonProperty("Value")
    private String value;

    public OMDBRating(){}

    public OMDBRating(String source, String value) {
        this.source = source;
        this.value = value;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "source='" + source + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
