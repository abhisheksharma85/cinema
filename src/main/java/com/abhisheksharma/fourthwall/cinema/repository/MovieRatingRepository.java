package com.abhisheksharma.fourthwall.cinema.repository;

import com.abhisheksharma.fourthwall.cinema.domain.MovieRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Spring Data JPA repository for the Movie entity.
 */
@Repository
public interface MovieRatingRepository extends JpaRepository<MovieRating, Long> {


    @Query("SELECT ROUND(AVG(mr.star),1) from MovieRating mr where mr.movieId = :movieId")
    float getAverageStar(Long movieId);

    @Query("SELECT mr from MovieRating mr where mr.movieId = :movieId")
    List<MovieRating> findByMovieId(Long movieId);


}
