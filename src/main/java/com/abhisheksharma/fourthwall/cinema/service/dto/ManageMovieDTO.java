package com.abhisheksharma.fourthwall.cinema.service.dto;

import java.time.Instant;


/**
 * A DTO for the Movie List for Admin Users.
 */
public class ManageMovieDTO extends MovieDTO{

    private Integer franchiseId;

    private Instant createdAt;

    private Instant updatedAt;

    private Long createdBy;

    private Long updatedBy;

    private Boolean active;

    private String imdbId;

    public ManageMovieDTO(){}

    public ManageMovieDTO(Integer franchiseId, String imdbId, Instant createdAt, Instant updatedAt, Long createdBy, Long updatedBy, Boolean active) {
        this.franchiseId = franchiseId;
        this.imdbId = imdbId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.active = active;
    }

    public ManageMovieDTO(Long id, String name, String description, Integer franchiseId, String imdbId,
                          Instant createdAt, Instant updatedAt, Long createdBy, Long updatedBy, Boolean active) {
        super(id, name,description);
        this.franchiseId = franchiseId;
        this.imdbId = imdbId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.active = active;
    }

    public Integer getFranchiseId() {
        return franchiseId;
    }

    public void setFranchiseId(Integer franchiseId) {
        this.franchiseId = franchiseId;
    }

    public String getImdbId() { return imdbId; }

    public void setImdbId(String imdbId) { this.imdbId = imdbId; }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "ManageMovieDTO{" +
                "franchiseId=" + franchiseId +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy=" + createdBy +
                ", updatedBy=" + updatedBy +
                ", active=" + active +
                ", imdbId='" + imdbId + '\'' +
                '}';
    }
}
