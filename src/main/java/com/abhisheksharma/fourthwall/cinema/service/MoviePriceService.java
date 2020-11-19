package com.abhisheksharma.fourthwall.cinema.service;


import com.abhisheksharma.fourthwall.cinema.service.dto.IdValueDTO;
import com.abhisheksharma.fourthwall.cinema.service.dto.MovieShowPriceDTO;

import java.util.List;

/**
 * Service Interface for managing Movie Price.
 */
public interface MoviePriceService {


    List<IdValueDTO<Long,String>> findPriceTypes();

    MovieShowPriceDTO findMoviePrice(Long showTimeId);
}
