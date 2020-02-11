package com.zenhomes.counter.ws;

import java.net.URI;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zenhomes.counter.service.CounterService;
import com.zenhomes.counter.service.dto.CounterDto;
import com.zenhomes.counter.ws.exception.BadRequestException;
import com.zenhomes.counter.ws.vm.ConsumptionReport;
import com.zenhomes.counter.ws.vm.FilterDate;

/**
 * REST controller for managing
 */
@RestController
public class CounterResource {

	private final Logger log = LoggerFactory.getLogger(CounterResource.class);

	@Autowired
	private CounterService counterService;

	/**
	 * {@code GET  /counter_callback} : receive energy consumption for counter.
	 * 
	 * @return the {@link ResponseEntity} with status {@code 200 (OK)}
	 * @throws URISyntaxException
	 */
	@PostMapping("/counter_callback")
	public ResponseEntity<CounterDto> getAllProducts(@RequestBody CounterDto dto) throws URISyntaxException {
		log.debug("Request to insert energy amount for counter");
		if (dto.getId() != null) {
			throw new BadRequestException("Bad request. Invalid Id property");
		};
		dto = counterService.save(dto);
		return ResponseEntity.created(new URI("/counter_callback" + dto.getId())).body(dto);
	}

	@GetMapping("/consumption_report")
	public ResponseEntity<ConsumptionReport> getConsumptionReport(@RequestParam FilterDate duration) {
		log.debug("Request to insert energy amount for counter");
		return new ResponseEntity<>(counterService.getConsumptionReport(duration), HttpStatus.OK);

	}

}
