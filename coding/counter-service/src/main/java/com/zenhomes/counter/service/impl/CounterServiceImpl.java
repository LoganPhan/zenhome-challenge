package com.zenhomes.counter.service.impl;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
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
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Component
public class CounterServiceImpl implements CounterService {

	@Autowired
	private CounterRepository counterRepo;

	@Autowired
	private CounterMapper counterMapper;

	@Autowired
	private VillageClient villageClient;

	@Autowired
	private RestTemplate restTemplate;

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

	@Override
	public Page<CounterDto> getAll() {

		return counterRepo.findAll(PageRequest.of(0, 2)).map(counterMapper::toDto);
	}

	@Override
	public String getRegistration() {
		String rest = restTemplate.getForObject("https://servicearizona.com/VehicleRegistration/renew", String.class);
		return rest;
	}

	@Override
	public String postRegistration(String params) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
		map.add("recordNumber", null);
		map.add("vin", null);
		map.add("_eventId_unknown", null);

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

		String url = "https://servicearizona.com/VehicleRegistration/renew" + "?execution=" + params;
		String rest = restTemplate.postForObject(url,request, String.class);
		return rest;
	}
}
