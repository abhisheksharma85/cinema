package com.abhisheksharma.fourthwall.cinema.service.impl;

import com.abhisheksharma.fourthwall.cinema.domain.MoviePrice;
import com.abhisheksharma.fourthwall.cinema.domain.MovieShowTime;
import com.abhisheksharma.fourthwall.cinema.domain.PriceType;
import com.abhisheksharma.fourthwall.cinema.repository.MoviePriceRepository;
import com.abhisheksharma.fourthwall.cinema.repository.MovieShowTimeRepository;
import com.abhisheksharma.fourthwall.cinema.repository.PriceTypeRepository;
import com.abhisheksharma.fourthwall.cinema.service.MoviePriceService;
import com.abhisheksharma.fourthwall.cinema.service.dto.IdValueDTO;
import com.abhisheksharma.fourthwall.cinema.service.dto.MoviePriceDTO;
import com.abhisheksharma.fourthwall.cinema.service.dto.MovieShowPriceDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service Implementation for managing Movie Price.
 */
@Service
@Transactional
public class MoviePriceServiceImpl implements MoviePriceService {

    private final Logger log = LoggerFactory.getLogger(FranchiseServiceImpl.class);

    private final MoviePriceRepository moviePriceRepository;

    private final PriceTypeRepository priceTypeRepository;

    private final MovieShowTimeRepository movieShowTimeRepository;

    public MoviePriceServiceImpl(PriceTypeRepository priceTypeRepository,MoviePriceRepository moviePriceRepository,MovieShowTimeRepository movieShowTimeRepository){
        this.priceTypeRepository = priceTypeRepository;
        this.moviePriceRepository = moviePriceRepository;
        this.movieShowTimeRepository = movieShowTimeRepository;
    }


    @Override
    public List<IdValueDTO<Integer, String>> findPriceTypes() {
        List<PriceType> priceTypes = priceTypeRepository.findAll();
        List<IdValueDTO<Integer, String>> result = new ArrayList<>(priceTypes.size());
        for(PriceType priceType: priceTypes){
            result.add(new IdValueDTO<Integer, String>(priceType.getId(),priceType.getName()));
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

    @Override
    public List<IdValueDTO<Long,Float>> saveMoviePrice(MoviePriceDTO moviePriceDTO) {
        log.debug("Request to Save Movie Price : {}");
        MovieShowTime showTime = movieShowTimeRepository.getOne(moviePriceDTO.getShowTimeId());
        List<PriceType> _priceType = priceTypeRepository.findAll();
        Map<Integer,PriceType> priceTypes = new HashMap<>(_priceType.size());
        for(PriceType priceType : _priceType) {
            priceTypes.put(priceType.getId(),priceType);
        }
        List<MoviePrice> prices = new ArrayList<>(moviePriceDTO.getPrice().size());

        for(IdValueDTO<Integer,Float> price: moviePriceDTO.getPrice()) {
            prices.add(new MoviePrice(showTime, priceTypes.get(price.getId()),price.getValue(),1l));
        }
        List<IdValueDTO<Long,Float>> result = null;
        prices = moviePriceRepository.saveAll(prices);
        result = new ArrayList<>(prices.size());
        for(MoviePrice price: prices) {
            result.add(new IdValueDTO<>(price.getId(),price.getPrice()));
        }
        return result;
    }

    @Override
    public boolean updatePrice(IdValueDTO<Long, Float> price) {
        log.debug("Request to Update Movie Price : {}",price);

        int updated = moviePriceRepository.updatePrice(price.getId(), price.getValue());

        return updated == 1 ? true : false;
    }
}
