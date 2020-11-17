package com.abhisheksharma.fourthwall.cinema.service.dto;

import java.time.Instant;

/**
 * A DTO for the Movie entity.
 */
public class MovieDTO {

    private Long id;

    private String name;

    private Integer franchiseId;

    private Instant releasedDate;

    private Instant createdAt;

    private Instant updatedAt;

    private Long createdBy;

    private Long updatedBy;

    private Boolean active;

    private String imdbId;

    public MovieDTO(){}

    public MovieDTO(Long id, String name, Integer franchiseId, Instant releasedDate, Instant createdAt, Instant updatedAt, Long createdBy, Long updatedBy, Boolean active, String imdbId) {
        this.id = id;
        this.name = name;
        this.franchiseId = franchiseId;
        this.releasedDate = releasedDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.active = active;
        this.imdbId = imdbId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFranchiseId() {
        return franchiseId;
    }

    public void setFranchiseId(Integer franchiseId) {
        this.franchiseId = franchiseId;
    }

    public Instant getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(Instant releasedDate) {
        this.releasedDate = releasedDate;
    }

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

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    @Override
    public String toString() {
        return "MovieDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", franchiseId=" + franchiseId +
                ", releasedDate=" + releasedDate +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy=" + createdBy +
                ", updatedBy=" + updatedBy +
                ", active=" + active +
                ", imdbId='" + imdbId + '\'' +
                '}';
    }
}
