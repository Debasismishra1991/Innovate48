package com.fisglobal.inovate48.dmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.fisglobal.inovate48.dmt.entity.LkClientProduct;

/**
 * @author Debasis.Mishra
 *
 */
@RepositoryRestResource
public interface LkClientProductRepository extends JpaRepository<LkClientProduct, Long> {

	@Query(value = "Select * from LK_CLIENT_PRODUCT LCP WHERE LCP.PRODUCT_ID = :productId AND LCP.CLIENT_ID= :clientId", nativeQuery = true)
	LkClientProduct getClientProductID(@Param("productId") long productId, @Param("clientId") long clientId);
}
