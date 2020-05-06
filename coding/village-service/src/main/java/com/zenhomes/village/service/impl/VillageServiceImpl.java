package com.zenhomes.village.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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

	@Override
	@Transactional
	public void getCheckout(Long id, Long quantity) {
		 doCheckout(id, quantity);
	}
	
	@Override
	@Transactional
	public void getCheckout2(Long id, Long quantity) {
		doCheckout2(id, quantity);
	}
	
	private void doCheckout(Long id, Long quantity) {
		System.out.println(String.format("Thread 1: %s  id: %s ----- quantity: %s", Thread.currentThread().getName(), id, quantity));
		try {
			Village village = villageRepo.findCheckoutById(id);
			System.out.println(String.format("Quantity is %s and current Quantity is: %s", village.getQuantity(), quantity));
			Thread.sleep(10000);
			if(village.getQuantity() < quantity) {
				System.out.println("AAA -> quantity: " + quantity);
			}else {
				System.out.println(String.format("BBBBBBBBBBBBBBBBBBBBBBb + %s", quantity));
				village.setQuantity(village.getQuantity() - quantity);
				villageRepo.save(village);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void doCheckout2(Long id, Long quantity) {
		System.out.println(String.format("Thread 2: %s id: %s ----- quantity: %s", Thread.currentThread().getName(),id, quantity));
		try {
			Village village = villageRepo.findCheckoutById(id);
			System.out.println(String.format("Quantity is %s and current Quantity is: %s", village.getQuantity(), quantity));
			village.setQuantity(village.getQuantity() - quantity);
			villageRepo.save(village);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
