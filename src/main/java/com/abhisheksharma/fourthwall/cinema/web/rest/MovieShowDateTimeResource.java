package com.abhisheksharma.fourthwall.cinema.web.rest;

import com.abhisheksharma.fourthwall.cinema.domain.MovieShowDate;
import com.abhisheksharma.fourthwall.cinema.service.MovieService;
import com.abhisheksharma.fourthwall.cinema.service.MovieShowTimeService;
import com.abhisheksharma.fourthwall.cinema.service.dto.IdValueDTO;
import com.abhisheksharma.fourthwall.cinema.service.dto.MovieShowDateRequestDTO;
import com.abhisheksharma.fourthwall.cinema.service.dto.MovieShowDateTimeDTO;
import com.abhisheksharma.fourthwall.cinema.service.dto.MovieShowTimeRequestDTO;
import com.abhisheksharma.fourthwall.cinema.web.rest.error.BadRequestAlertException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * REST controller for managing Movie Show and Time.
 */
@RestController
@RequestMapping("/api")
public class MovieShowDateTimeResource {

    private final Logger log = LoggerFactory.getLogger(MovieShowDateTimeResource.class);

    private static final String ENTITY_NAME = "movie-show-and-time";

    private final MovieShowTimeService movieShowTimeService;

    public MovieShowDateTimeResource(MovieShowTimeService movieShowTimeService){
        this.movieShowTimeService = movieShowTimeService;
    }


    @PostMapping("/manage/movie/show-date-time")
    public void addShowDateTime(@RequestBody MovieShowDateTimeDTO movieShowDateTimeDTO){
        log.debug("REST request to save Movie Date and Time");
        movieShowTimeService.saveDateTime(movieShowDateTimeDTO);

    }

    @PostMapping("/manage/movie/show-date")
    public ResponseEntity<IdValueDTO<Long, LocalDate>> addShowDate(@RequestBody MovieShowDateRequestDTO movieShowDateRequestDTO){
        log.debug("REST request to save Movie Date and Time");
        if (movieShowDateRequestDTO.getId() != null) {
            throw new BadRequestAlertException("A new show date cannot already have an ID", ENTITY_NAME, "idexists");
        }
        IdValueDTO<Long, LocalDate> result = movieShowTimeService.saveDate(movieShowDateRequestDTO);
        if(result != null) {
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PostMapping("/manage/movie/show-time")
    public ResponseEntity<IdValueDTO<Long, LocalTime>> addShowTime(@RequestBody MovieShowTimeRequestDTO movieShowTimeRequestDTO){
        log.debug("REST request to save Movie Time");
        if (movieShowTimeRequestDTO.getId() != null) {
            throw new BadRequestAlertException("A new show time cannot already have an ID", ENTITY_NAME, "idexists");
        }
        IdValueDTO<Long, LocalTime> result = movieShowTimeService.saveTime(movieShowTimeRequestDTO);
        if(result != null) {
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/manage/movie/show-time")
    public ResponseEntity<IdValueDTO<Long, LocalTime>> updateShowTime(@RequestBody MovieShowTimeRequestDTO movieShowTimeRequestDTO){
        log.debug("REST request to update Movie Time");

        IdValueDTO<Long, LocalTime> result = movieShowTimeService.saveTime(movieShowTimeRequestDTO);
        if(result != null) {
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

}
