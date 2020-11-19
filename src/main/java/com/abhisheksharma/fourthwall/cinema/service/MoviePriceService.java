package com.abhisheksharma.fourthwall.cinema.service;


import com.abhisheksharma.fourthwall.cinema.service.dto.MovieShowPriceDTO;

/**
 * Service Interface for managing Movie Price.
 */
public interface MoviePriceService {

    MovieShowPriceDTO findMoviePrice(Long showTimeId);
}
