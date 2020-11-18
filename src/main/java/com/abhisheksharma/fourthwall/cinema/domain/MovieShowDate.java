package com.abhisheksharma.fourthwall.cinema.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * A MovieShowDate.
 */
@Entity
@Table(name = "fw_cinema_movie_showdate")
public class MovieShowDate implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "movie_id")
    private Long movieId;

    @NotNull
    @Column(name = "show_date", columnDefinition = "DATE")
    private LocalDate showDate;

    @NotNull
    @Column(name = "active", nullable = false)
    private Boolean active;

    public MovieShowDate(){}

    public MovieShowDate(Long id, @NotNull Long movieId, @NotNull LocalDate showDate, @NotNull Boolean active) {
        this.id = id;
        this.movieId = movieId;
        this.showDate = showDate;
        this.active = active;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Long getMovieId() { return movieId; }

    public void setMovieId(Long movieId) { this.movieId = movieId; }

    public LocalDate getShowDate() { return showDate; }

    public void setShowDate(LocalDate showDate) { this.showDate = showDate; }

    public Boolean getActive() { return active; }

    public void setActive(Boolean active) { this.active = active; }

    @Override
    public String toString() {
        return "MovieShowDate{" +
                "id=" + id +
                ", movieId=" + movieId +
                ", showDate=" + showDate +
                ", active=" + active +
                '}';
    }
}
