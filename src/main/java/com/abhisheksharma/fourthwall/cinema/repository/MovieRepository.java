package com.abhisheksharma.fourthwall.cinema.repository;

import com.abhisheksharma.fourthwall.cinema.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data JPA repository for the Movie entity.
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Modifying
    @Query("Update Movie m set m.star = :star where m.id = :id")
    void updateRatingById(Long id, float star);

    @Query("SELECT m FROM Movie m where m.active = :active")
    List<Movie> findByActive(boolean active);
}
