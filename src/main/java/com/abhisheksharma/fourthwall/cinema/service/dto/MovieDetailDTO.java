package com.abhisheksharma.fourthwall.cinema.service.dto;

/**
 * A DTO for the Movie Detail entity.
 */
public class MovieDetailDTO extends MovieDTO{

    private String releasedDate;

    private Float rating;

    private Float imdbRating;

    public MovieDetailDTO(){}

    public MovieDetailDTO(String releasedDate, Float rating, Float imdbRating) {
        this.releasedDate = releasedDate;
        this.rating = rating;
        this.imdbRating = imdbRating;
    }

    public MovieDetailDTO(Long id, String name, String description, Float rating) {
        super(id, name, description);
        this.rating = rating;
    }

    public MovieDetailDTO(Long id, String name, String description, String releasedDate, Float rating, Float imdbRating) {
        super(id, name, description);
        this.releasedDate = releasedDate;
        this.rating = rating;
        this.imdbRating = imdbRating;
    }

    public String getReleasedDate() { return releasedDate; }

    public void setReleasedDate(String releasedDate) { this.releasedDate = releasedDate; }

    public Float getRating() { return rating; }

    public void setRating(Float rating) { this.rating = rating; }

    public Float getImdbRating() { return imdbRating; }

    public void setImdbRating(Float imdbRating) { this.imdbRating = imdbRating; }

    @Override
    public String toString() {
        return "MovieDetailDTO{" +
                "releasedDate='" + releasedDate + '\'' +
                ", rating=" + rating +
                ", imdbRating=" + imdbRating +
                '}';
    }
}
