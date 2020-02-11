package com.zenhomes.counter.service;

import java.util.List;

import com.zenhomes.counter.service.dto.CounterDto;
import com.zenhomes.counter.ws.vm.ConsumptionReport;
import com.zenhomes.counter.ws.vm.FilterDate;

/**
 * 
 * @author LoganPhan
 *
 */
public interface CounterService {
	
	/**
	 * 
	 * @param dto
	 * @return
	 */
	CounterDto save(CounterDto dto);
	
	ConsumptionReport getConsumptionReport(FilterDate duration);
	

	List<CounterDto> getCounters();
	
	void deleteAll();
}
