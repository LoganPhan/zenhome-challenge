package com.zenhomes.counter.service.impl;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zenhomes.counter.client.VillageClient;
import com.zenhomes.counter.domain.Counter;
import com.zenhomes.counter.repository.CounterRepository;
import com.zenhomes.counter.service.CounterService;
import com.zenhomes.counter.service.dto.CounterDto;
import com.zenhomes.counter.service.mapper.CounterMapper;
import com.zenhomes.counter.ws.vm.CodeResponse;
import com.zenhomes.counter.ws.vm.ConsumptionReport;
import com.zenhomes.counter.ws.vm.FilterDate;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CounterServiceImpl implements CounterService {

	@Autowired
	private CounterRepository counterRepo;

	@Autowired
	private CounterMapper counterMapper;

	@Autowired
	private VillageClient villageClient;

	@Override
	public CounterDto save(CounterDto dto) {
		Counter entity = counterMapper.toEntity(dto);
		entity = counterRepo.save(entity);
		dto = counterMapper.toDto(entity);
		return dto;
	}

	@Override
	public ConsumptionReport getConsumptionReport(FilterDate duration) {
		Instant[] ranges = duration.getDateTime();
		List<CounterDto> villages = counterRepo.getConsumptionReport(ranges[0], ranges[1]);
		return ConsumptionReport.builder().villages(villages.stream().map(ite -> {
			CodeResponse res = villageClient.getCounterInformation(ite.getCounterId());
			
			return ConsumptionReport.Village.builder()
					.villageName(res.getCode().split(":")[2].replace("\"", ""))
					.consumption(ite.getAmount()).build();
		}).collect(Collectors.toList())).build();
	}

	@Override
	public List<CounterDto> getCounters() {
		return counterRepo.findAll().stream().map(counterMapper::toDto).collect(Collectors.toList());
		
	}

	@Override
	public void deleteAll() {
		counterRepo.deleteAll();
	}
}
