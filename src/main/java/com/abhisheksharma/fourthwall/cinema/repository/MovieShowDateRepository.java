package com.abhisheksharma.fourthwall.cinema.repository;


import com.abhisheksharma.fourthwall.cinema.domain.MovieShowDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Spring Data JPA repository for the MovieShowDate entity.
 */
@Repository
public interface MovieShowDateRepository  extends JpaRepository<MovieShowDate, Long> {

    @Query("SELECT msd from MovieShowDate msd where msd.movieId = :movieId")
    List<MovieShowDate> findByMovieId(Long movieId);
}
