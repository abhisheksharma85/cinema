package com.abhisheksharma.fourthwall.cinema.service.impl;

import com.abhisheksharma.fourthwall.cinema.domain.MovieRating;
import com.abhisheksharma.fourthwall.cinema.repository.MovieRatingRepository;
import com.abhisheksharma.fourthwall.cinema.repository.MovieRepository;
import com.abhisheksharma.fourthwall.cinema.security.SecurityUtils;
import com.abhisheksharma.fourthwall.cinema.service.MovieRatingService;
import com.abhisheksharma.fourthwall.cinema.service.dto.MovieRatingDTO;
import com.abhisheksharma.fourthwall.cinema.service.mapper.MovieRatingMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * Service Implementation for managing Movie Rating.
 */
@Service
@Transactional
public class MovieRatingServiceImpl implements MovieRatingService {

    private final Logger log = LoggerFactory.getLogger(MovieRatingServiceImpl.class);

    private final MovieRatingRepository movieRatingRepository;

    private final MovieRatingMapper movieRatingMapper;

    private final MovieRepository movieRepository;

    public MovieRatingServiceImpl(MovieRatingRepository movieRatingRepository, MovieRatingMapper movieRatingMapper, MovieRepository movieRepository){
        this.movieRatingRepository = movieRatingRepository;
        this.movieRatingMapper = movieRatingMapper;
        this.movieRepository = movieRepository;
    }

    @Override
    public MovieRatingDTO save(MovieRatingDTO movieRatingDTO) {
        log.debug("Request to save Rating : {}", movieRatingDTO);
        Long userId = 1l;//SecurityUtils.getCurrentUserId().get();
        movieRatingDTO.setCreatedAt(Instant.now());
        movieRatingDTO.setCreatedBy(userId);
        MovieRating movieRating = movieRatingMapper.toEntity(movieRatingDTO);
        movieRating = movieRatingRepository.save(movieRating);
        MovieRatingDTO result = movieRatingMapper.toDto(movieRating);
        movieRepository.updateRatingById(movieRatingDTO.getMovieId(),findAvgStarRatingByMovie(movieRatingDTO.getMovieId()));
        return result;
    }

    @Override
    public List<MovieRatingDTO> findAll() {
        return null;
    }

    @Override
    public List<MovieRatingDTO> findByMovieId(Long movieId) {
        return movieRatingRepository.findByMovieId(movieId).stream()
                .map(movieRatingMapper::toDto)
                .collect(Collectors.toCollection(LinkedList::new));
    }


    public float findAvgStarRatingByMovie(Long movieId){
        log.debug("Request to get Average Rating of a movie: {}", movieId);
        return movieRatingRepository.getAverageStar(movieId);
    }

}
