package com.abhisheksharma.fourthwall.cinema.service.impl;

import com.abhisheksharma.fourthwall.cinema.domain.Franchise;
import com.abhisheksharma.fourthwall.cinema.repository.FranchiseRepository;
import com.abhisheksharma.fourthwall.cinema.service.FranchiseService;
import com.abhisheksharma.fourthwall.cinema.service.dto.FranchiseDTO;
import com.abhisheksharma.fourthwall.cinema.service.mapper.FranchiseMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing Franchise.
 */
@Service
@Transactional
public class FranchiseServiceImpl implements FranchiseService {

    private final Logger log = LoggerFactory.getLogger(FranchiseServiceImpl.class);

    private final FranchiseMapper franchiseMapper;

    private final FranchiseRepository franchiseRepository;

    public FranchiseServiceImpl(FranchiseMapper franchiseMapper, FranchiseRepository franchiseRepository){
        this.franchiseMapper = franchiseMapper;
        this.franchiseRepository = franchiseRepository;
    }

    /**
     * Save a franchise.
     *
     * @param franchiseDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public FranchiseDTO save(FranchiseDTO franchiseDTO) {
        log.debug("Request to save Franchise : {}", franchiseDTO);
        Franchise franchise = franchiseMapper.toEntity(franchiseDTO);
        franchise.setCreatedAt(Instant.now());
        franchise = franchiseRepository.save(franchise);
        FranchiseDTO result = franchiseMapper.toDto(franchise);
        return result;
    }

    /**
     * Get all the franchises.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<FranchiseDTO> findAll() {
        log.debug("Request to get all Franchises");
        return franchiseRepository.findAll().stream()
                .map(franchiseMapper::toDto)
                .collect(Collectors.toCollection(LinkedList::new));
    }
}
