package com.zenhomes.counter.service.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.zenhomes.counter.ws.vm.FilterDate;

/**
 * 
 * @author LoganPhan
 *
 */
@Component
public class FilterDateConverter implements Converter<String, FilterDate> {

	@Override
	public FilterDate convert(String value) {
		return FilterDate.of(value);
	}

}