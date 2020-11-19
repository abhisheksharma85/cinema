package com.abhisheksharma.fourthwall.cinema.service;

import com.abhisheksharma.fourthwall.cinema.domain.MovieShowDate;
import com.abhisheksharma.fourthwall.cinema.service.dto.IdValueDTO;
import com.abhisheksharma.fourthwall.cinema.service.dto.MovieShowDateRequestDTO;
import com.abhisheksharma.fourthwall.cinema.service.dto.MovieShowDateTimeDTO;
import com.abhisheksharma.fourthwall.cinema.service.dto.MovieShowTimeRequestDTO;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Service Interface for managing Movie Show Time.
 */
public interface MovieShowTimeService {

    IdValueDTO<Long, LocalDate> saveDate(MovieShowDateRequestDTO movieShowDateRequestDTO);

    IdValueDTO<Long, LocalDate> updateDate(MovieShowDateRequestDTO movieShowDateRequestDTO);

    IdValueDTO<Long, LocalTime> saveTime(MovieShowTimeRequestDTO movieShowTimeRequestDTO);

    IdValueDTO<Long, LocalTime> updateTime(MovieShowTimeRequestDTO movieShowTimeRequestDTO);

    void saveDateTime(MovieShowDateTimeDTO movieShowDateTimeDTO);
}
