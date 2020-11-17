package com.abhisheksharma.fourthwall.cinema.web.rest;

import com.abhisheksharma.fourthwall.cinema.config.Constants;
import com.abhisheksharma.fourthwall.cinema.service.MovieRatingService;
import com.abhisheksharma.fourthwall.cinema.service.dto.MovieRatingDTO;
import com.abhisheksharma.fourthwall.cinema.web.rest.error.BadRequestAlertException;
import com.abhisheksharma.fourthwall.cinema.web.rest.util.HeaderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * REST controller for managing Movie Rating.
 */
@RestController
@RequestMapping("/api")
public class MovieRatingResource {

    private final Logger log = LoggerFactory.getLogger(MovieResource.class);

    private static final String ENTITY_NAME = "movie-rating";

    private final MovieRatingService movieRatingService;

    public MovieRatingResource(MovieRatingService movieRatingService){ this.movieRatingService = movieRatingService;}


    @PostMapping("/ratings")
    public ResponseEntity<MovieRatingDTO> addRating(@Valid @RequestBody MovieRatingDTO movieRatingDTO) throws URISyntaxException {
        log.debug("REST request to save Rating : {}", movieRatingDTO);
        if (movieRatingDTO.getId() != null) {
            throw new BadRequestAlertException("A new rating cannot already have an ID", ENTITY_NAME, "idexists");
        }
        if (movieRatingDTO.getStar().floatValue() > Constants.MAX_RATING.floatValue()) {
            throw new BadRequestAlertException("Rating cannot be more than "+Constants.MAX_RATING, ENTITY_NAME, "invalid rating");
        }

        MovieRatingDTO result = movieRatingService.save(movieRatingDTO);
        return ResponseEntity.created(new URI("/api/ratings/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
                .body(result);
    }

}
