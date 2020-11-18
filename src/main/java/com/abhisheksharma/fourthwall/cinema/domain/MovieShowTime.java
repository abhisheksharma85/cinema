package com.abhisheksharma.fourthwall.cinema.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalTime;

/**
 * A MovieShowDate.
 */
@Entity
@Table(name = "fw_cinema_movie_showtime")
public class MovieShowTime implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "movie_id")
    private Long movieId;

    @NotNull
    @Column(name = "show_time", columnDefinition = "TIME")
    private LocalTime showTime;

    @ManyToOne
    @JoinColumn(name = "showdate_id", nullable = false)
    private MovieShowDate movieShowDate;

    @NotNull
    @Column(name = "active", nullable = false)
    private Boolean active;

    public MovieShowTime(){}

    public MovieShowTime(Long id, @NotNull Long movieId, @NotNull LocalTime showTime, MovieShowDate movieShowDate, @NotNull Boolean active) {
        this.id = id;
        this.movieId = movieId;
        this.showTime = showTime;
        this.movieShowDate = movieShowDate;
        this.active = active;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Long getMovieId() { return movieId; }

    public void setMovieId(Long movieId) { this.movieId = movieId; }

    public LocalTime getShowTime() { return showTime; }

    public void setShowTime(LocalTime showTime) { this.showTime = showTime; }

    public MovieShowDate getMovieShowDate() { return movieShowDate; }

    public void setMovieShowDate(MovieShowDate movieShowDate) { this.movieShowDate = movieShowDate; }

    public Boolean getActive() { return active; }

    public void setActive(Boolean active) { this.active = active; }

    @Override
    public String toString() {
        return "MovieShowTime{" +
                "id=" + id +
                ", movieId=" + movieId +
                ", showTime=" + showTime +
                ", movieShowDate=" + movieShowDate +
                ", active=" + active +
                '}';
    }
}
