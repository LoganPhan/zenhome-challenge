package com.zenhomes.village.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zenhomes.village.domain.Village;
import com.zenhomes.village.repository.VillageRepository;
import com.zenhomes.village.service.VillageService;
import com.zenhomes.village.service.dto.VillageDto;
import com.zenhomes.village.service.mapper.VillageMapper;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class VillageServiceImpl implements VillageService {

	@Autowired
	private VillageRepository villageRepo;

	@Autowired
	private VillageMapper villageMapper;

	@Override
	public VillageDto save(VillageDto dto) {
		Village entity = villageMapper.toEntity(dto);
		entity = villageRepo.save(entity);
		dto = villageMapper.toDto(entity);
		return dto;
	}

	@Override
	public VillageDto findById(Long id) {
		return villageMapper.toDto(villageRepo.getOne(id));
	}

	@Override
	public void deleteAll() {
		villageRepo.deleteAll();
	}

	@Override
	public List<VillageDto> getVillages() {
		return villageRepo.findAll().stream().map(villageMapper::toDto).collect(Collectors.toList());
	}
}
