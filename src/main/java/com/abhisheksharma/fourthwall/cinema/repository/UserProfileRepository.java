package com.abhisheksharma.fourthwall.cinema.repository;

import com.abhisheksharma.fourthwall.cinema.domain.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the UserProfile entity.
 */
@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
}

