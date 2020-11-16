package com.abhisheksharma.fourthwall.cinema.service.mapper;

import com.abhisheksharma.fourthwall.cinema.domain.Movie;
import com.abhisheksharma.fourthwall.cinema.service.dto.MovieDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity Movie and its DTO MovieDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface MovieMapper extends EntityMapper<MovieDTO, Movie> {

    default Movie fromId(Long id) {
        if (id == null) {
            return null;
        }
        Movie movie = new Movie();
        movie.setId(id);
        return movie;
    }

}
