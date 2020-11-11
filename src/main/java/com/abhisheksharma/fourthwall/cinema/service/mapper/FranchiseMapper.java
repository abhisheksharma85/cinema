package com.abhisheksharma.fourthwall.cinema.service.mapper;

import com.abhisheksharma.fourthwall.cinema.domain.Franchise;
import com.abhisheksharma.fourthwall.cinema.service.dto.FranchiseDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity Franchise and its DTO FranchiseDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface FranchiseMapper extends EntityMapper<FranchiseDTO, Franchise> {

    default Franchise fromId(Integer id) {
        if (id == null) {
            return null;
        }
        Franchise franchise = new Franchise();
        franchise.setId(id);
        return franchise;
    }

}
