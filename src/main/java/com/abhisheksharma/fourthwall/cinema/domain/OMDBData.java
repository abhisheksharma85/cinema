package com.abhisheksharma.fourthwall.cinema.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

/**
 * A OMDBData.
 */
@Entity
@Table(name = "fw_cinema_omdb_data")
public class OMDBData implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "imdb_id")
    private String imdbId;

    @Column(name = "imdb_data")
    private String imdbData;

    @Column(name = "created_at")
    private Instant createdAt;

    public OMDBData(){}

    public OMDBData(Long id, String imdbId, String imdbData, Instant createdAt) {
        this.id = id;
        this.imdbId = imdbId;
        this.imdbData = imdbData;
        this.createdAt = createdAt;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getImdbId() { return imdbId; }

    public void setImdbId(String imdbId) { this.imdbId = imdbId; }

    public String getImdbData() { return imdbData; }

    public void setImdbData(String imdbData) { this.imdbData = imdbData; }

    public Instant getCreatedAt() { return createdAt; }

    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }

    @Override
    public String toString() {
        return "OMDBData{" +
                "id=" + id +
                ", imdbId='" + imdbId + '\'' +
                ", imdbData='" + imdbData + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
