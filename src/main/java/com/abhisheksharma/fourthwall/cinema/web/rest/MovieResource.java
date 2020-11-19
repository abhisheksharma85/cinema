package com.abhisheksharma.fourthwall.cinema.web.rest;



import com.abhisheksharma.fourthwall.cinema.service.MoviePriceService;
import com.abhisheksharma.fourthwall.cinema.service.MovieRatingService;
import com.abhisheksharma.fourthwall.cinema.service.MovieService;
import com.abhisheksharma.fourthwall.cinema.service.dto.*;
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

    private final MoviePriceService moviePriceService;

    public MovieResource(MovieService movieService,MovieRatingService movieRatingService,MoviePriceService moviePriceService){
        this.movieService = movieService;
        this.movieRatingService = movieRatingService;
        this.moviePriceService = moviePriceService;
    }

    /**
     * GET  /movies : get all the movies.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of movies in body
     */
    @GetMapping("/movies")
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
    public ResponseEntity<MovieDetailDTO> getMovieDetail(@PathVariable Long id) {
        log.debug("REST request to get Movie detail {}",id);
        MovieDetailDTO result = movieService.findDetail(id);
        movieService.findMovieDate(id);
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
    public ResponseEntity<List<MovieRatingDTO>> getMovieRatings(@PathVariable Long id) {
        log.debug("REST request to get Movie Rating by movie id {}",id);
        List<MovieRatingDTO> result = movieRatingService.findByMovieId(id);
        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    /**
     * GET  /movies/{id}/show-date : get movie show-date.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of movie show date in body
     */
    @GetMapping("/movies/{id}/show-date")
    public ResponseEntity<List<MovieShowDateDTO>> getMovieShowDate(@PathVariable Long id) {
        log.debug("REST request to get Movie Show Date by movie id {}",id);
        List<MovieShowDateDTO> result = movieService.findMovieDate(id);
        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    /**
     * GET  /movies/{id}/show-date/{showDateId}/show-timing : get movie show-date.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of movie show date in body
     */
    @GetMapping("/movies/{id}/show-date/{showDateId}/show-time")
    public ResponseEntity<MovieShowTimeDTO> getMovieShowTime(@PathVariable Long id, @PathVariable Long showDateId) {
        log.debug("REST request to get Movie Show Date by movie id and show-date id {},{}",id,showDateId);
        MovieShowTimeDTO result = movieService.findMovieTime(id,showDateId);
        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    /**
     * GET  /movies/{id}/show-timing/{showTimeId}/prices : get movie show-date.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of movie show time price in body
     */
    @GetMapping("/movies/{id}/show-time/{showTimeId}/prices")
    public ResponseEntity<MovieShowPriceDTO> getMoviePrice(@PathVariable Long id, @PathVariable Long showTimeId) {
        log.debug("REST request to get Movie Show Price by movie id, show-time id{}",id,showTimeId);

        MovieShowPriceDTO result = moviePriceService.findMoviePrice(showTimeId);
        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }




}
