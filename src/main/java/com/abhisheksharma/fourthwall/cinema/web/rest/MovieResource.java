package com.abhisheksharma.fourthwall.cinema.web.rest;


import com.abhisheksharma.fourthwall.cinema.service.MovieService;
import com.abhisheksharma.fourthwall.cinema.service.dto.FranchiseDTO;
import com.abhisheksharma.fourthwall.cinema.service.dto.MovieDTO;
import io.micrometer.core.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller for managing Movie.
 */
@RestController
@RequestMapping("/api")
public class MovieResource {


    private final Logger log = LoggerFactory.getLogger(MovieResource.class);

    private static final String ENTITY_NAME = "movie";

    private final MovieService movieService;

    public MovieResource(MovieService movieService){
        this.movieService = movieService;
    }

    /**
     * Admin API /api/manage/...
     */

    /**
     * GET  /movies : get all the movies.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of movies in body
     */
    @GetMapping("/movies")
    @Timed
    public ResponseEntity<List<MovieDTO>> getAllMovie() {
        log.debug("REST request to get all Franchises ");
        List<MovieDTO> movies = movieService.findAll();
        if(movies !=null && movies.size() > 0){
            return new ResponseEntity<>(movies, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(movies, HttpStatus.NO_CONTENT);
        }
    }

    /**
     * User API
     */


}
