package com.abhisheksharma.fourthwall.cinema.service.impl;

import com.abhisheksharma.fourthwall.cinema.domain.MoviePrice;
import com.abhisheksharma.fourthwall.cinema.repository.MoviePriceRepository;
import com.abhisheksharma.fourthwall.cinema.service.MoviePriceService;
import com.abhisheksharma.fourthwall.cinema.service.dto.MovieShowPriceDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing Movie Price.
 */
@Service
@Transactional
public class MoviePriceServiceImpl implements MoviePriceService {

    private final Logger log = LoggerFactory.getLogger(FranchiseServiceImpl.class);

    private final MoviePriceRepository moviePriceRepository;

    public MoviePriceServiceImpl(MoviePriceRepository moviePriceRepository){
        this.moviePriceRepository = moviePriceRepository;
    }


    @Override
    public MovieShowPriceDTO findMoviePrice(Long showTimeId) {
        log.debug("Request to get Movie Price : {}");
        List<MoviePrice> moviePrices = moviePriceRepository.findAll();
        MovieShowPriceDTO result = new MovieShowPriceDTO(showTimeId);
        if(moviePrices != null) {
            result.setPricing(moviePrices);
        }
        return result;
    }
}
