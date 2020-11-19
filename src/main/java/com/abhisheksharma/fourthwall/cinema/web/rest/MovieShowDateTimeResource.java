package com.abhisheksharma.fourthwall.cinema.web.rest;

import com.abhisheksharma.fourthwall.cinema.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for managing Movie Show and Time.
 */
@RestController
@RequestMapping("/api")
public class MovieShowDateTimeResource {

    private final Logger log = LoggerFactory.getLogger(MovieResource.class);

    private static final String ENTITY_NAME = "movie-show-and-time";

    private final MovieService movieService;

    public MovieShowDateTimeResource(MovieService movieService){
        this.movieService = movieService;
    }


}
