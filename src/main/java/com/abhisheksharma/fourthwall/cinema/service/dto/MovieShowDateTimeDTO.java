package com.abhisheksharma.fourthwall.cinema.service.dto;

import java.util.List;

public class MovieShowDateTimeDTO {

    private Long movieId;

    List<DateTimeDTO> showDateTime;

    public MovieShowDateTimeDTO(){}

    public MovieShowDateTimeDTO(Long movieId, List<DateTimeDTO> showDateTime) {
        this.movieId = movieId;
        this.showDateTime = showDateTime;
    }

    public Long getMovieId() { return movieId; }

    public void setMovieId(Long movieId) { this.movieId = movieId; }

    public List<DateTimeDTO> getShowDateTime() { return showDateTime; }

    public void setShowDateTime(List<DateTimeDTO> showDateTime) { this.showDateTime = showDateTime; }
}
