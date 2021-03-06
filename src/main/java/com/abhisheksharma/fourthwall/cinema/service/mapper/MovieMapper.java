package com.abhisheksharma.fourthwall.cinema.service.mapper;

import com.abhisheksharma.fourthwall.cinema.domain.Movie;
import com.abhisheksharma.fourthwall.cinema.service.dto.ManageMovieDTO;
import com.abhisheksharma.fourthwall.cinema.service.dto.MovieDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity Movie and its DTO ManageMovieDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface MovieMapper extends EntityMapper<ManageMovieDTO, Movie> {

    default Movie fromId(Long id) {
        if (id == null) {
            return null;
        }
        Movie movie = new Movie();
        movie.setId(id);
        return movie;
    }

}
