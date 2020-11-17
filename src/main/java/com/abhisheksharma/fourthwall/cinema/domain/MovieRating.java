package com.abhisheksharma.fourthwall.cinema.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

/**
 * A Movie Rating.
 */
@Entity
@Table(name = "fw_cinema_movie_rating")
public class MovieRating implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "subject", nullable = false)
    private String subject;

    @NotNull
    @Column(name = "movie_id", nullable = false)
    private Long movieId;

    @NotNull
    @Column(name = "description", nullable = false)
    private String description;

    @NotNull
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "user_id")
    private Long createdBy;

    @NotNull
    @Column(name = "star", nullable = false)
    private Float star;

    public MovieRating(){}

    public MovieRating(Long id, @NotNull String subject, @NotNull Long movieId, @NotNull String description, @NotNull Instant createdAt, Long createdBy, @NotNull Float star) {
        this.id = id;
        this.subject = subject;
        this.movieId = movieId;
        this.description = description;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.star = star;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getStar() {
        return star;
    }

    public void setStar(Float star) {
        this.star = star;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "MovieRating{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", movieId=" + movieId +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", createdBy=" + createdBy +
                ", star=" + star +
                '}';
    }
}
