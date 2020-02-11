package com.zenhomes.counter.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zenhomes.counter.ws.vm.CodeResponse;

/**
 * 
 * @author LoganPhan
 *
 */
@FeignClient(name="village-services" )
public interface VillageClient {
	
	@GetMapping(value = "/counter", consumes = MediaType.APPLICATION_XML_VALUE)
	public CodeResponse getCounterInformation(@RequestParam(value="id") Long id);
	
}
