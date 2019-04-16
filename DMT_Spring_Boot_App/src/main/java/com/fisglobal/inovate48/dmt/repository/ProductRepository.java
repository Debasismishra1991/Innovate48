package com.fisglobal.inovate48.dmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.fisglobal.inovate48.dmt.entity.Product;

/**
 * @author Debasis.Mishra
 *
 */
@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(value = "Select P.PRODUCT_ID, P.PRODUCT_NAME from PRODUCT P JOIN LK_CLIENT_PRODUCT CP ON (P.PRODUCT_ID = CP.PRODUCT_ID) WHERE CP.CLIENT_ID = :clientId ", nativeQuery = true)
	public List<Product> getProductsForClient(@Param("clientId") long clientId);
}
