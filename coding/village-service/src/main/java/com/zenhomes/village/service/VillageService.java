package com.zenhomes.village.service;

import java.util.List;

import com.zenhomes.village.service.dto.VillageDto;

/**
 * 
 * @author LoganPhan
 *
 */
public interface VillageService {
	
	/**
	 * store Village into Db
	 * @param dto
	 * @return
	 */
	VillageDto save(VillageDto dto);
	
	/**
	 * store Village into Db
	 * @param dto
	 * @return
	 */
	List<VillageDto> getVillages();
	
	/**
	 * Get village informations
	 * @param dto
	 * @return
	 */
	VillageDto findById(Long id);
	
	/**
	 * Remove All village
	 * @param dto
	 * @return
	 */
	void deleteAll();
}
