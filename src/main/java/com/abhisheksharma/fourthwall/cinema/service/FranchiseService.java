package com.abhisheksharma.fourthwall.cinema.service;


import com.abhisheksharma.fourthwall.cinema.service.dto.FranchiseDTO;

import java.util.List;

/**
 * Service Interface for managing Franchise.
 */
public interface FranchiseService {


    /**
     * Save a franchise.
     *
     * @param franchiseDTO the entity to save
     * @return the persisted entity
     */
    FranchiseDTO save(FranchiseDTO franchiseDTO);

    /**
     * Get all the franchises.
     *
     * @return the list of entities
     */
    List<FranchiseDTO> findAll();
}
