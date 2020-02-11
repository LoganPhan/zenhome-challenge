package com.zenhomes.counter.service.mapper;

import org.mapstruct.Mapper;

import com.zenhomes.counter.domain.Counter;
import com.zenhomes.counter.service.dto.CounterDto;

/**
 * Mapper for the entity {@link Counter} and its DTO {@link CounterDto}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface CounterMapper extends EntityMapper<CounterDto, Counter> {

	default Counter fromId(Long id) {
		if (id == null) {
			return null;
		}
		Counter counter = new Counter();
		counter.setId(id);
		return counter;
	}
}
