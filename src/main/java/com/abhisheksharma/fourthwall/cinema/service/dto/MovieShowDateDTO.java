package com.abhisheksharma.fourthwall.cinema.service.dto;

import com.abhisheksharma.fourthwall.cinema.domain.MovieShowDate;
import com.abhisheksharma.fourthwall.cinema.service.util.HelperUtil;

public class MovieShowDateDTO {

    private Long id;

    private Long movieId;

    private String date;

    private String day;

    public MovieShowDateDTO(){}

    public MovieShowDateDTO(MovieShowDate showDate){
        this.id = showDate.getId();
        this.movieId = showDate.getMovieId();
        this.date = showDate.getShowDate().format(HelperUtil.getUSDateFormat());
        this.day = showDate.getShowDate().getDayOfWeek().name();
    }
    public MovieShowDateDTO(Long id, Long movieId, String date, String day) {
        this.id = id;
        this.movieId = movieId;
        this.date = date;
        this.day = day;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Long getMovieId() { return movieId; }

    public void setMovieId(Long movieId) { this.movieId = movieId; }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }

    public String getDay() { return day; }

    public void setDay(String day) { this.day = day; }

    @Override
    public String toString() {
        return "MovieShowDateDTO{" +
                "id=" + id +
                ", movieId=" + movieId +
                ", date='" + date + '\'' +
                ", day='" + day + '\'' +
                '}';
    }
}
