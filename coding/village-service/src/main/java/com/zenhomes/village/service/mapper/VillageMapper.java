package com.zenhomes.village.service.mapper;

import org.mapstruct.Mapper;

import com.zenhomes.village.domain.Village;
import com.zenhomes.village.service.dto.VillageDto;

/**
 * Mapper for the entity {@link Village} and its DTO {@link VillageDto}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface VillageMapper extends EntityMapper<VillageDto, Village> {

	default Village fromId(Long id) {
		if (id == null) {
			return null;
		}
		Village village = new Village();
		village.setId(id);
		return village;
	}
}
