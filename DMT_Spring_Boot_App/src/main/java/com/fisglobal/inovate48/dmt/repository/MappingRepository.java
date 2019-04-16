package com.fisglobal.inovate48.dmt.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.fisglobal.inovate48.dmt.entity.Mapping;

/**
 * @author Debasis.Mishra
 *
 */
@RepositoryRestResource
public interface MappingRepository extends JpaRepository<Mapping, Long> {

	@Query(value = "Select * from MAPPING M WHERE M.CLI_PRO_ID = :cliProId AND M.MODULE_ID= :moduleId", nativeQuery = true)
	Collection<Mapping> getAllMappings(@Param("cliProId") long cliProId,@Param("moduleId")  long moduleId);
}