package com.abhisheksharma.fourthwall.cinema.service.impl;


import com.abhisheksharma.fourthwall.cinema.domain.Movie;
import com.abhisheksharma.fourthwall.cinema.repository.MovieRepository;
import com.abhisheksharma.fourthwall.cinema.service.MovieService;
import com.abhisheksharma.fourthwall.cinema.service.dto.MovieDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Service Implementation for managing Movie.
 */
@Service
@Transactional
public class MovieServiceImpl implements MovieService {

    private final Logger log = LoggerFactory.getLogger(FranchiseServiceImpl.class);

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }


    /**
     * Save a movie.
     *
     * @param movieDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public MovieDTO save(MovieDTO movieDTO) {
        log.debug("Request to save Movie : {}", movieDTO);

        MovieDTO result = null;
        return result;
    }

    /**
     * Get all the movies.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<MovieDTO> findAll() {
        log.debug("Request to get all Movies");
        for(Movie movie: movieRepository.findAll()){
            System.out.println(movie);
        }


        return null;
    }

}
