package com.abhisheksharma.fourthwall.cinema.service.dto;

import java.time.LocalDate;

public class MovieShowDateRequestDTO {

    private Long id;

    private Long movieId;

    private LocalDate showDate;

    public MovieShowDateRequestDTO(){}

    public MovieShowDateRequestDTO(Long id,Long movieId, LocalDate showDate) {
        this.id = id;
        this.movieId = movieId;
        this.showDate = showDate;
    }

    public MovieShowDateRequestDTO(Long movieId, LocalDate showDate) {
        this.movieId = movieId;
        this.showDate = showDate;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Long getMovieId() { return movieId; }

    public void setMovieId(Long movieId) { this.movieId = movieId; }

    public LocalDate getShowDate() { return showDate; }

    public void setShowDate(LocalDate showDate) { this.showDate = showDate; }

    @Override
    public String toString() {
        return "MovieShowDateRequestDTO{" +
                "movieId=" + movieId +
                ", showDate=" + showDate +
                '}';
    }
}
