package com.abhisheksharma.fourthwall.cinema.repository;

import com.abhisheksharma.fourthwall.cinema.domain.MoviePrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;

/**
 * Spring Data JPA repository for the Movie Price entity.
 */
@Repository
public interface MoviePriceRepository extends JpaRepository<MoviePrice,Long> {


    @Modifying
    @Query(value = "UPDATE fw_cinema_movie_price mp set mp.price = :price, mp.updated_at = NOW() where mp.id = :id ",nativeQuery = true)
    int updatePrice(@Param("id") Long id, @Param("price") Float price);

}
