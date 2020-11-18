package com.abhisheksharma.fourthwall.cinema.service;

import com.abhisheksharma.fourthwall.cinema.service.dto.FranchiseDTO;
import com.abhisheksharma.fourthwall.cinema.service.dto.MovieDTO;
import com.abhisheksharma.fourthwall.cinema.service.dto.MovieDetailDTO;

import java.util.List;
import java.util.Optional;

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

    /**
     * Get the "id" movie.
     *
     * @param id the id of the entity
     * @return the entity
     */
    MovieDetailDTO findDetail(Long id);



}
