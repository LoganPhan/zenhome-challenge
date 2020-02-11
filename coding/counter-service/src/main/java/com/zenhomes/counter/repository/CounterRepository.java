package com.zenhomes.counter.repository;
import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zenhomes.counter.domain.Counter;
import com.zenhomes.counter.service.dto.CounterDto;


/**
 * Spring Data  repository for the Counter entity.
 */
@Repository
public interface CounterRepository extends JpaRepository<Counter, Long>, JpaSpecificationExecutor<Counter> {

	@Query(value = "SELECT "
	 		+ " new com.zenhomes.counter.service.dto.CounterDto(-1L, SUM(amount),  counterId)"
	 		+ " FROM Counter "
	 		+ " WHERE createdAt >= :from "
	 		+ "   AND createdAt <= :to "
	 		+ " GROUP BY counterId"
	 		, nativeQuery = false)
	 List<CounterDto> getConsumptionReport(@Param("from") Instant from, @Param("to") Instant to);
	 
}
