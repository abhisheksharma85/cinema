package com.abhisheksharma.fourthwall.cinema.repository;

import com.abhisheksharma.fourthwall.cinema.domain.Movie;
import com.abhisheksharma.fourthwall.cinema.domain.OMDBData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the OMDBData entity.
 */
@Repository
public interface OMDBDataRepository  extends JpaRepository<Movie, Long> {


    @Query("SELECT o from OMDBData o where o.imdbId = :imdbId")
    OMDBData findByImdbId(String imdbId);
}
