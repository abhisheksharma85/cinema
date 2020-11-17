package com.abhisheksharma.fourthwall.cinema.service;

import com.abhisheksharma.fourthwall.cinema.service.dto.FranchiseDTO;
import com.abhisheksharma.fourthwall.cinema.service.dto.MovieDTO;

import java.util.List;

/**
 * Service Interface for managing Movie.
 */
public interface MovieService {

    /**
     * Save a movie.
     *
     * @param movieDTO the entity to save
     * @return the persisted entity
     */
    MovieDTO save(MovieDTO movieDTO);

    /**
     * Get all the movies.
     *
     * @return the list of entities
     */
    List<MovieDTO> findAll();
}
