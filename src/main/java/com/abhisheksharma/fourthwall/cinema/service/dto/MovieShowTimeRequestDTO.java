package com.abhisheksharma.fourthwall.cinema.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalTime;

public class MovieShowTimeRequestDTO {

    private Long id;

    private Long movieId;

    private Long showDateId;

    private LocalTime showTime ;

    public MovieShowTimeRequestDTO(){}

    public MovieShowTimeRequestDTO(Long id, LocalTime showTime) {
        this.id = id;
        this.showTime = showTime;
    }

    public MovieShowTimeRequestDTO(Long movieId, Long showDateId, LocalTime showTime) {
        this.movieId = movieId;
        this.showDateId = showDateId;
        this.showTime = showTime;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Long getMovieId() { return movieId; }

    public void setMovieId(Long movieId) { this.movieId = movieId; }

    public Long getShowDateId() { return showDateId; }

    public void setShowDateId(Long showDateId) { this.showDateId = showDateId; }

    public LocalTime getShowTime() { return showTime; }

    public void setShowTime(LocalTime showTime) { this.showTime = showTime; }

    @Override
    public String toString() {
        return "MovieShowTimeRequestDTO{" +
                "movieId=" + movieId +
                ", showDateId=" + showDateId +
                ", showTime=" + showTime +
                '}';
    }
}
