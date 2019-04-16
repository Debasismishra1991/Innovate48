package com.fisglobal.inovate48.dmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.fisglobal.inovate48.dmt.entity.ProductModule;

/**
 *
 * @author Debasis.Mishra
 *
 */
@RepositoryRestResource
public interface ProductModuleRepository extends JpaRepository<ProductModule, Long> {

	@Query(value = "Select * from MODULE M WHERE M.PRODUCT_ID = :productId ", nativeQuery = true)
	public List<ProductModule> getModulesForProduct(@Param("productId") long productId);
}
