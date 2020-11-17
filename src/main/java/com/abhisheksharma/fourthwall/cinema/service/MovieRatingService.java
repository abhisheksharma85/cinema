package com.abhisheksharma.fourthwall.cinema.service;
import com.abhisheksharma.fourthwall.cinema.service.dto.MovieRatingDTO;
import java.util.List;

/**
 * Service Interface for managing Movie Rating.
 */
public interface MovieRatingService {

    /**
     * Save a movie-ratings.
     *
     * @param movieRatingDTO the entity to save
     * @return the persisted entity
     */
    MovieRatingDTO save(MovieRatingDTO movieRatingDTO);

    /**
     * Get all the movie-ratings.
     *
     * @return the list of entities
     */
    List<MovieRatingDTO> findAll();

    /**
     *
     * @param movieId
     * @return the average rating value of a movie
     */
    float findAvgRatingByMovie(Long movieId);
}
