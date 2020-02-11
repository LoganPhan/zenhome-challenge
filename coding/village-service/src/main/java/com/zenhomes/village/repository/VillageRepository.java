package com.zenhomes.village.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.zenhomes.village.domain.Village;

/**
 * 
 * @author LoganPhan
 *
 */
@Repository
public interface VillageRepository extends JpaRepository<Village, Long>, JpaSpecificationExecutor<Village> {

}
