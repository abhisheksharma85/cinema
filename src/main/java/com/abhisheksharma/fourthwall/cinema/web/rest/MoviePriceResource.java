package com.abhisheksharma.fourthwall.cinema.web.rest;


import com.abhisheksharma.fourthwall.cinema.service.MoviePriceService;
import com.abhisheksharma.fourthwall.cinema.service.dto.IdValueDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller for managing Movie Price.
 */
@RestController
@RequestMapping("/api")
public class MoviePriceResource {

    private final Logger log = LoggerFactory.getLogger(MovieResource.class);

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
    public ResponseEntity<List<IdValueDTO<Long,String>>> getPriceType(){
        log.debug("REST request to get Price Types");
        List<IdValueDTO<Long,String>> result = moviePriceService.findPriceTypes();

        if(result != null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }




}
