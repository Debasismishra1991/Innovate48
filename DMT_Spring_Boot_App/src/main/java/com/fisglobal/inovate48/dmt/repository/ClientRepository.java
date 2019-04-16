package com.fisglobal.inovate48.dmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.fisglobal.inovate48.dmt.entity.Client;

/**
 * @author Debasis.Mishra
 *
 */
@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client, Long> {
}
