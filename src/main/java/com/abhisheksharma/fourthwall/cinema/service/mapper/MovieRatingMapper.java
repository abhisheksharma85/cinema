package com.abhisheksharma.fourthwall.cinema.service.mapper;

import com.abhisheksharma.fourthwall.cinema.domain.MovieRating;
import com.abhisheksharma.fourthwall.cinema.service.dto.MovieRatingDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity Movie and its DTO MovieDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface MovieRatingMapper  extends EntityMapper<MovieRatingDTO, MovieRating> {

    default MovieRating fromId(Long id) {
        if (id == null) {
            return null;
        }
        MovieRating movieRating = new MovieRating();
        movieRating.setId(id);
        return movieRating;
    }
}
