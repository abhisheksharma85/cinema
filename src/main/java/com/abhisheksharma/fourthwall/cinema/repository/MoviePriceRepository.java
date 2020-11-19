package com.abhisheksharma.fourthwall.cinema.repository;

import com.abhisheksharma.fourthwall.cinema.domain.MoviePrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Movie Price entity.
 */
@Repository
public interface MoviePriceRepository extends JpaRepository<MoviePrice,Long> {
}
