package com.abhisheksharma.fourthwall.cinema.web.rest;


import com.abhisheksharma.fourthwall.cinema.service.MoviePriceService;
import com.abhisheksharma.fourthwall.cinema.service.dto.IdValueDTO;
import com.abhisheksharma.fourthwall.cinema.service.dto.MoviePriceDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing Movie Price.
 */
@RestController
@RequestMapping("/api")
public class MoviePriceResource {

    private final Logger log = LoggerFactory.getLogger(MoviePriceResource.class);

    private static final String ENTITY_NAME = "movie-price";

    private final MoviePriceService moviePriceService;

    public MoviePriceResource(MoviePriceService moviePriceService){
        this.moviePriceService = moviePriceService;
    }

    /**
     * GET  /manage/movie/price-types : get price type.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of price type in body
     */
    @GetMapping("/manage/movie/price-types")
    public ResponseEntity<List<IdValueDTO<Integer,String>>> getPriceType(){
        log.debug("REST request to get Price Types");
        List<IdValueDTO<Integer,String>> result = moviePriceService.findPriceTypes();
        if(result != null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    /**
     * POST  /manage/movie/prices : save prices
     *
     * @param moviePriceDTO
     */
    @PostMapping("/manage/movie/prices")
    public ResponseEntity<List<IdValueDTO<Long,Float>>> addPrice(@RequestBody MoviePriceDTO moviePriceDTO){
        log.debug("REST request to add Movie Price {}", moviePriceDTO);
        List<IdValueDTO<Long,Float>> result = moviePriceService.saveMoviePrice(moviePriceDTO);

        if(result != null) {
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
     *
     * @param price
     * @return
     */
    @PutMapping("/manage/movie/prices")
    public ResponseEntity<IdValueDTO<Long,Float>> updatePrice(@RequestBody IdValueDTO<Long,Float> price){
        log.debug("REST request to update Movie Price by id{}", price);

        boolean result = moviePriceService.updatePrice(price);

        if(result) {
            return new ResponseEntity<>(price, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(price, HttpStatus.EXPECTATION_FAILED);
        }
    }





}
