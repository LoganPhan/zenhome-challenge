package com.zenhomes.village.repository;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zenhomes.village.domain.Village;

/**
 * 
 * @author LoganPhan
 *
 */
@Repository
public interface VillageRepository extends JpaRepository<Village, Long>, JpaSpecificationExecutor<Village> {
	
	@Query(value = "SELECT v FROM Village as v WHERE id = :id")
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	Village findCheckoutById(@Param("id") long id);
}
