package com.abhisheksharma.fourthwall.cinema.service.impl;


import com.abhisheksharma.fourthwall.cinema.domain.Movie;
import com.abhisheksharma.fourthwall.cinema.domain.MovieShowDate;
import com.abhisheksharma.fourthwall.cinema.domain.MovieShowTime;
import com.abhisheksharma.fourthwall.cinema.domain.OMDBData;
import com.abhisheksharma.fourthwall.cinema.repository.MovieRepository;
import com.abhisheksharma.fourthwall.cinema.repository.MovieShowDateRepository;
import com.abhisheksharma.fourthwall.cinema.repository.MovieShowTimeRepository;
import com.abhisheksharma.fourthwall.cinema.repository.OMDBDataRepository;
import com.abhisheksharma.fourthwall.cinema.security.AuthoritiesConstants;
import com.abhisheksharma.fourthwall.cinema.security.SecurityUtils;
import com.abhisheksharma.fourthwall.cinema.service.MovieService;
import com.abhisheksharma.fourthwall.cinema.service.dto.*;
import com.abhisheksharma.fourthwall.cinema.service.mapper.MovieMapper;
import com.abhisheksharma.fourthwall.cinema.service.mapper.ViewMovieMapper;
import com.abhisheksharma.fourthwall.cinema.service.util.ExternalDataUtil;
import com.abhisheksharma.fourthwall.cinema.service.util.HelperUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing Movie.
 */
@Service
@Transactional
public class MovieServiceImpl implements MovieService {

    private final Logger log = LoggerFactory.getLogger(MovieServiceImpl.class);

    private final MovieRepository movieRepository;

    private final MovieMapper movieMapper;

    private final ViewMovieMapper viewMovieMapper;

    private final ExternalDataUtil externalDataUtil;

    private final OMDBDataRepository omdbDataRepository;

    private final MovieShowDateRepository movieShowDateRepository;

    private final MovieShowTimeRepository movieShowTimeRepository;


    public MovieServiceImpl(MovieRepository movieRepository,MovieMapper movieMapper, ViewMovieMapper viewMovieMapper,ExternalDataUtil externalDataUtil,
                            OMDBDataRepository omdbDataRepository,MovieShowDateRepository movieShowDateRepository,MovieShowTimeRepository movieShowTimeRepository){
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
        this.viewMovieMapper = viewMovieMapper;
        this.externalDataUtil = externalDataUtil;
        this.omdbDataRepository = omdbDataRepository;
        this.movieShowDateRepository = movieShowDateRepository;
        this.movieShowTimeRepository = movieShowTimeRepository;
    }


    /**
     * Save a movie.
     *
     * @param movieDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public MovieDTO save(MovieDTO movieDTO) {
        log.debug("Request to save Movie : {}", movieDTO);




        MovieDTO result = null;
        return result;
    }

    /**
     * Get all the movies.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<MovieDTO> findAll() {
        log.debug("Request to get all Movies");
        if (SecurityUtils.getAuthority().get().equals(AuthoritiesConstants.ADMIN)) {
            return movieRepository.findAll().stream()
                    .map(movieMapper::toDto)
                    .collect(Collectors.toCollection(LinkedList::new));
        } else {
            return movieRepository.findByActive(true).stream()
                    .map(viewMovieMapper::toDto)
                    .collect(Collectors.toCollection(LinkedList::new));
        }
    }

    @Override
    public MovieDetailDTO findDetail(Long id) {
        log.debug("Request to get Movie Detail : {}", id);
        Movie movie = movieRepository.getOne(id);

        MovieDetailDTO movieDetailDTO = null;

        if(movie != null) {
            movieDetailDTO = new MovieDetailDTO(movie.getId(),movie.getName(),movie.getDescription(),movie.getStar());
            OMDBDataDTO omdbDataDTO = externalDataUtil.getOMDBData(movie.getImdbId());
            if(omdbDataDTO == null) {
                OMDBData omdbData = omdbDataRepository.findByImdbId(movie.getImdbId());
                if(omdbData != null && omdbData.getImdbData() != null) {
                    ObjectMapper mapper = new ObjectMapper();
                    try {
                        omdbDataDTO = mapper.readValue(omdbData.getImdbData(),OMDBDataDTO.class);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                }
            }
            if(omdbDataDTO != null) {
                movieDetailDTO.setImdbRating(omdbDataDTO.getImdbRating());
                movieDetailDTO.setReleasedDate(omdbDataDTO.getReleased());
            }
        }
        return movieDetailDTO;
    }

    @Override
    public List<MovieShowDateDTO> findMovieDate(Long id) {
        log.debug("Request to get Movie Show Date : {}", id);
        List<MovieShowDate> movieShowDates = movieShowDateRepository.findByMovieId(id);
        List<MovieShowDateDTO> result = null;
        if(movieShowDates != null){
            result = new ArrayList<>(movieShowDates.size());
            for(MovieShowDate showDate : movieShowDates){
                result.add(new MovieShowDateDTO(showDate));
            }
        }
        return result;
    }

    @Override
    public MovieShowTimeDTO findMovieTime(Long id, Long showDateId) {
        log.debug("Request to get Movie Show Time : {}", id);
        List<MovieShowTime> movieShowTimes = movieShowTimeRepository.findByMovieIdAndShowDate(id,showDateId);
        MovieShowTimeDTO result = new MovieShowTimeDTO(id,showDateId);
        if(movieShowTimes != null){
            result.setTimings(movieShowTimes);
        }
        return result;
    }


}
