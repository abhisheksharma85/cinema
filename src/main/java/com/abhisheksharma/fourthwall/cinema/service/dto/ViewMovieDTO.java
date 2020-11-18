package com.abhisheksharma.fourthwall.cinema.service.dto;


/**
 * A DTO for the Movie List for Users.
 */
public class ViewMovieDTO extends MovieDTO{

    private Float star;

    public ViewMovieDTO(){}

    public ViewMovieDTO(Float star) {
        this.star = star;
    }

    public ViewMovieDTO(Long id, String name, String description, Float star) {
        super(id, name,description);
        this.star = star;
    }

    public Float getStar() {
        return star;
    }

    public void setStar(Float star) {
        this.star = star;
    }

    @Override
    public String toString() {
        return "ViewMovieDTO{" +
                "star=" + star +
                '}';
    }
}
