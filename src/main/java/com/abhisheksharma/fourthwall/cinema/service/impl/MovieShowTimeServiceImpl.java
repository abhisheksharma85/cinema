package com.abhisheksharma.fourthwall.cinema.service.impl;

import com.abhisheksharma.fourthwall.cinema.domain.MovieShowDate;
import com.abhisheksharma.fourthwall.cinema.domain.MovieShowTime;
import com.abhisheksharma.fourthwall.cinema.repository.MovieShowDateRepository;
import com.abhisheksharma.fourthwall.cinema.repository.MovieShowTimeRepository;
import com.abhisheksharma.fourthwall.cinema.service.MovieShowTimeService;
import com.abhisheksharma.fourthwall.cinema.service.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Service Implementation for managing Movie Show and Time.
 */
@Service
@Transactional
public class MovieShowTimeServiceImpl implements MovieShowTimeService {


    private final Logger log = LoggerFactory.getLogger(MovieShowTimeServiceImpl.class);

    private final MovieShowDateRepository movieShowDateRepository;

    private final MovieShowTimeRepository movieShowTimeRepository;

    public MovieShowTimeServiceImpl(MovieShowDateRepository movieShowDateRepository,MovieShowTimeRepository movieShowTimeRepository){
        this.movieShowDateRepository = movieShowDateRepository;
        this.movieShowTimeRepository = movieShowTimeRepository;
    }

    @Override
    public IdValueDTO<Long, LocalDate> saveDate(MovieShowDateRequestDTO movieShowDateRequestDTO) {
        log.debug("Request to save Movie Date {}",movieShowDateRequestDTO);
        MovieShowDate movieShowDate = new MovieShowDate(movieShowDateRequestDTO.getMovieId(), movieShowDateRequestDTO.getShowDate());
        movieShowDate = movieShowDateRepository.save(movieShowDate);
        IdValueDTO<Long, LocalDate> result = new IdValueDTO<>(movieShowDate.getId(), movieShowDate.getShowDate());
        return result;
    }

    @Override
    public IdValueDTO<Long, LocalDate> updateDate(MovieShowDateRequestDTO movieShowDateRequestDTO) {
        log.debug("Request to update Movie Date {}",movieShowDateRequestDTO);
        MovieShowDate movieShowDate = movieShowDateRepository.getOne(movieShowDateRequestDTO.getId());
        movieShowDate.setShowDate(movieShowDateRequestDTO.getShowDate());
        movieShowDate = movieShowDateRepository.save(movieShowDate);
        IdValueDTO<Long, LocalDate> result = new IdValueDTO<>(movieShowDate.getId(), movieShowDate.getShowDate());
        return result;
    }

    @Override
    public IdValueDTO<Long, LocalTime> saveTime(MovieShowTimeRequestDTO movieShowTimeRequestDTO) {
        log.debug("Request to save Movie Time {}",movieShowTimeRequestDTO);
        MovieShowDate movieShowDate = movieShowDateRepository.getOne(movieShowTimeRequestDTO.getShowDateId());
        MovieShowTime movieShowTime = new MovieShowTime(movieShowTimeRequestDTO.getMovieId(), movieShowTimeRequestDTO.getShowTime(), movieShowDate);
        movieShowTime = movieShowTimeRepository.save(movieShowTime);
        IdValueDTO<Long, LocalTime> result = new IdValueDTO<>(movieShowTime.getId(), movieShowTime.getShowTime());
        return result;
    }

    @Override
    public IdValueDTO<Long, LocalTime> updateTime(MovieShowTimeRequestDTO movieShowTimeRequestDTO) {
        log.debug("Request to update Movie Time {}",movieShowTimeRequestDTO);
        MovieShowTime movieShowTime = movieShowTimeRepository.getOne(movieShowTimeRequestDTO.getId());
        movieShowTime.setShowTime(movieShowTimeRequestDTO.getShowTime());
        movieShowTime = movieShowTimeRepository.save(movieShowTime);
        IdValueDTO<Long,LocalTime> result = new IdValueDTO<>(movieShowTime.getId(),movieShowTime.getShowTime());
        return result;
    }

    @Override
    public void saveDateTime(MovieShowDateTimeDTO movieShowDateTimeDTO) {
        log.debug("Request to save Movie Date and Time {}",movieShowDateTimeDTO);

        List<MovieShowDate> movieShowDateList = new ArrayList<>(movieShowDateTimeDTO.getShowDateTime().size());

        for(DateTimeDTO dateTimeDTO: movieShowDateTimeDTO.getShowDateTime()){
            //movieShowDateList.add(new MovieShowDate(movieShowDateTimeDTO.getMovieId(),dateTimeDTO.getShowDate()));
            System.out.println(movieShowDateTimeDTO.getMovieId()+"  ::  "+dateTimeDTO.getShowDate());
        }

        movieShowDateList = movieShowDateRepository.saveAll(movieShowDateList);

        for(MovieShowDate d: movieShowDateList){
            System.out.println(d.getId()+"  ::  "+d.getShowDate());
        }


    }
}
