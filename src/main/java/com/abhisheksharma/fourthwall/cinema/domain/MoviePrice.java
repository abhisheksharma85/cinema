package com.abhisheksharma.fourthwall.cinema.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

/**
 * A Movie Price.
 */
@Entity
@Table(name = "fw_cinema_movie_price")
public class MoviePrice implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "showtime_id", nullable = false)
    private MovieShowTime showTime;

    @ManyToOne
    @JoinColumn(name = "price_type_id", nullable = false)
    private PriceType priceType;

    @Column(name = "price", nullable = false)
    private Float price;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "created_by", nullable = false)
    private Long createdBy;

    @Column(name = "updated_by")
    private Long updatedBy;

    @Column(name = "active", nullable = false)
    private Boolean active;

    public MoviePrice(){}

    public MoviePrice(Long id, MovieShowTime showTime, PriceType priceType, Float price, Instant createdAt, Instant updatedAt, Long createdBy, Long updatedBy, Boolean active) {
        this.id = id;
        this.showTime = showTime;
        this.priceType = priceType;
        this.price = price;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.active = active;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public MovieShowTime getShowTime() { return showTime; }

    public void setShowTime(MovieShowTime showTime) { this.showTime = showTime; }

    public PriceType getPriceType() { return priceType; }

    public void setPriceType(PriceType priceType) { this.priceType = priceType; }

    public Float getPrice() { return price; }

    public void setPrice(Float price) { this.price = price; }

    public Instant getCreatedAt() { return createdAt; }

    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }

    public Instant getUpdatedAt() { return updatedAt; }

    public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }

    public Long getCreatedBy() { return createdBy; }

    public void setCreatedBy(Long createdBy) { this.createdBy = createdBy; }

    public Long getUpdatedBy() { return updatedBy; }

    public void setUpdatedBy(Long updatedBy) { this.updatedBy = updatedBy; }

    public Boolean getActive() { return active; }

    public void setActive(Boolean active) { this.active = active; }

    @Override
    public String toString() {
        return "MoviePrice{" +
                "id=" + id +
                ", showTime=" + showTime +
                ", priceType=" + priceType +
                ", price=" + price +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy=" + createdBy +
                ", updatedBy=" + updatedBy +
                ", active=" + active +
                '}';
    }
}
