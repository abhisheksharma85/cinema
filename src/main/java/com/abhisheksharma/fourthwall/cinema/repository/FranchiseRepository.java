package com.abhisheksharma.fourthwall.cinema.repository;


import com.abhisheksharma.fourthwall.cinema.domain.Franchise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Franchise entity.
 */
@Repository
public interface FranchiseRepository extends JpaRepository<Franchise, Integer>{
}
