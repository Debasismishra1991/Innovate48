package com.fisglobal.inovate48.dmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.fisglobal.inovate48.dmt.entity.Fields;

/**
 * @author Debasis.Mishra
 *
 */
@RepositoryRestResource
public interface FieldsRepository extends JpaRepository<Fields, Long> {

	@Query(value = "Select * from FIELDS F WHERE F.MODULE_ID = :moduleId", nativeQuery = true)
	List<Fields> getFieldsForModule(@Param("moduleId") long moduleId);

}