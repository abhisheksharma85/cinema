package com.abhisheksharma.fourthwall.cinema.web.rest;

import com.abhisheksharma.fourthwall.cinema.service.FranchiseService;
import com.abhisheksharma.fourthwall.cinema.service.dto.FranchiseDTO;
import io.micrometer.core.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller for managing Franchise.
 */
@RestController
@RequestMapping("/api")
public class FranchiseResource {
    private final Logger log = LoggerFactory.getLogger(FranchiseResource.class);

    private static final String ENTITY_NAME = "franchise";

    private final FranchiseService franchiseService;

    public FranchiseResource(FranchiseService franchiseService){
        this.franchiseService = franchiseService;
    }


    /**
     * GET  /franchises : get all the franchises.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of franchises in body
     */
    @GetMapping("/franchises")
    @Timed
    public ResponseEntity<List<FranchiseDTO>> getAllFranchise() {
        log.debug("REST request to get all Franchises ");
        List<FranchiseDTO> franchises = franchiseService.findAll();
        if(franchises !=null && franchises.size() > 0){
            return new ResponseEntity<>(franchises, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(franchises, HttpStatus.NO_CONTENT);
        }
    }

}
