package com.abhisheksharma.fourthwall.cinema.service.impl;

import com.abhisheksharma.fourthwall.cinema.domain.MoviePrice;
import com.abhisheksharma.fourthwall.cinema.domain.PriceType;
import com.abhisheksharma.fourthwall.cinema.repository.MoviePriceRepository;
import com.abhisheksharma.fourthwall.cinema.repository.PriceTypeRepository;
import com.abhisheksharma.fourthwall.cinema.service.MoviePriceService;
import com.abhisheksharma.fourthwall.cinema.service.dto.IdValueDTO;
import com.abhisheksharma.fourthwall.cinema.service.dto.MovieShowPriceDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Service Implementation for managing Movie Price.
 */
@Service
@Transactional
public class MoviePriceServiceImpl implements MoviePriceService {

    private final Logger log = LoggerFactory.getLogger(FranchiseServiceImpl.class);

    private final MoviePriceRepository moviePriceRepository;

    private final PriceTypeRepository priceTypeRepository;

    public MoviePriceServiceImpl(PriceTypeRepository priceTypeRepository,MoviePriceRepository moviePriceRepository){
        this.priceTypeRepository = priceTypeRepository;
        this.moviePriceRepository = moviePriceRepository;
    }


    @Override
    public List<IdValueDTO<Long, String>> findPriceTypes() {
        List<PriceType> priceTypes = priceTypeRepository.findAll();
        List<IdValueDTO<Long, String>> result = new ArrayList<>(priceTypes.size());
        for(PriceType priceType: priceTypes){
            result.add(new IdValueDTO<Long, String>(Long.valueOf(priceType.getId()),priceType.getName()));
        }
        return result;
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
