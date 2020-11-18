package com.abhisheksharma.fourthwall.cinema.repository;

import com.abhisheksharma.fourthwall.cinema.domain.MovieShowDate;
import com.abhisheksharma.fourthwall.cinema.domain.MovieShowTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data JPA repository for the MovieShowTime entity.
 */
@Repository
public interface MovieShowTimeRepository  extends JpaRepository<MovieShowTime, Long> {


    @Query("SELECT mst from MovieShowTime mst where mst.movieId = :movieId and mst.movieShowDate.id = :showDateId")
    List<MovieShowTime> findByMovieIdAndShowDate(Long movieId, Long showDateId);
}
