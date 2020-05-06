package com.zenhomes.village.ws;

import java.net.URI;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zenhomes.village.service.VillageService;
import com.zenhomes.village.service.dto.VillageDto;
import com.zenhomes.village.ws.exception.BadRequestException;
import com.zenhomes.village.ws.vm.CodeResponse;

import lombok.AllArgsConstructor;

/**
 * REST controller for managing .
 */
@RestController
@AllArgsConstructor
public class VillageResource {

	private final Logger log = LoggerFactory.getLogger(VillageResource.class);

	@Autowired
	private VillageService villageService;

	@Autowired
	private ObjectMapper objectMapper;

	/**
	 * {@code GET  /counter} : get counter informations
	 *
	 * @param criteria
	 *            the criteria which the requested entities should match.
	 * @return the {@link ResponseEntity} with status {@code 200 (OK)} in body.
	 * @throws JsonProcessingException
	 */
	@GetMapping(value = "/counter", produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<CodeResponse> getCounterById(@RequestParam Long id) throws JsonProcessingException {
		log.debug("Request get information additional information counter");
		VillageDto dto = villageService.findById(id);
		return new ResponseEntity<CodeResponse>(
				CodeResponse.builder().code(objectMapper.writeValueAsString(dto).replaceAll("[{}]", "")).build(),
				HttpStatus.OK);
	}
	
	/**
	 * {@code POST  /counter} : post counter informations
	 *
	 * @param criteria
	 *            the criteria which the requested entities should match.
	 * @return the {@link ResponseEntity} with status {@code 200 (OK)} in body.
	 * @throws JsonProcessingException
	 * @throws URISyntaxException 
	 */
	@PostMapping(value = "/counter")
	public ResponseEntity<VillageDto> save(@RequestBody VillageDto dto) throws URISyntaxException {
		log.debug("Request store village information");
		if(dto.getId() != null) {
			throw new BadRequestException("Bad request. Invalid Id property");
		}
		dto = villageService.save(dto);
		return ResponseEntity.created(new URI("/counter" + dto.getId()))
	            .body(dto);
	}
	
	/**
	 * {@code GET  /counter} : get counter informations
	 *
	 * @param criteria
	 *            the criteria which the requested entities should match.
	 * @return the {@link ResponseEntity} with status {@code 200 (OK)} in body.
	 * @throws JsonProcessingException
	 */
	@GetMapping(value = "/checkout")
	public ResponseEntity<Void> checkout(@RequestParam Long id, @RequestParam Long quantity) throws JsonProcessingException {
		log.debug("Request get information additional information counter");
		villageService.getCheckout(id, quantity);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	/**
	 * {@code GET  /counter} : get counter informations
	 *
	 * @param criteria
	 *            the criteria which the requested entities should match.
	 * @return the {@link ResponseEntity} with status {@code 200 (OK)} in body.
	 * @throws JsonProcessingException
	 */
	@GetMapping(value = "/checkout2")
	public ResponseEntity<Void> checkout2(@RequestParam Long id, @RequestParam Long quantity) throws JsonProcessingException {
		log.debug("Request get information additional information counter");
		villageService.getCheckout2(id, quantity);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
