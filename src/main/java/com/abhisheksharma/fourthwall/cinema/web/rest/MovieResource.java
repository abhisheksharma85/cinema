package com.abhisheksharma.fourthwall.cinema.web.rest;



import com.abhisheksharma.fourthwall.cinema.service.MovieRatingService;
import com.abhisheksharma.fourthwall.cinema.service.MovieService;
import com.abhisheksharma.fourthwall.cinema.service.dto.MovieDTO;
import com.abhisheksharma.fourthwall.cinema.service.dto.MovieDetailDTO;
import com.abhisheksharma.fourthwall.cinema.service.dto.MovieRatingDTO;
import io.micrometer.core.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    private final MovieRatingService movieRatingService;

    public MovieResource(MovieService movieService,MovieRatingService movieRatingService){
        this.movieService = movieService;
        this.movieRatingService = movieRatingService;
    }

    /**
     * GET  /movies : get all the movies.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of movies in body
     */
    @GetMapping("/movies")
    @Timed
    public ResponseEntity<List<MovieDTO>> getAllMovie() {
        log.debug("REST request to get all Movies ");
        List<MovieDTO> result = movieService.findAll();
        if(result !=null && result.size() > 0){
            return new ResponseEntity<>(result, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    /**
     * GET  /movies/{id} : get detail by movie id.
     *
     * @return the ResponseEntity with status 200 (OK) and the detail of movie in body
     */
    @GetMapping("/movies/{id}")
    @Timed
    public ResponseEntity<MovieDetailDTO> getMovieDetail(@PathVariable Long id) {
        log.debug("REST request to get Movie detail {}",id);
        MovieDetailDTO result = movieService.findDetail(id);
        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    /**
     * GET  /movies/{id}/ratings : get movie ratings.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of movie ratings in body
     */
    @GetMapping("/movies/{id}/ratings")
    @Timed
    public ResponseEntity<List<MovieRatingDTO>> getMovieRatings(@PathVariable Long id) {
        log.debug("REST request to get Movie Rating by movie id {}",id);
        List<MovieRatingDTO> result = movieRatingService.findByMovieId(id);
        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }



}
