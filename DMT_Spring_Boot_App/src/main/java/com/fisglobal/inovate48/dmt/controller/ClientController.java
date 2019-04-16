package com.fisglobal.inovate48.dmt.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fisglobal.inovate48.dmt.entity.Client;
import com.fisglobal.inovate48.dmt.repository.ClientRepository;

/**
 * @author Debasis.Mishra
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/client")
public class ClientController {

	private final ClientRepository clientRepository;

	@Autowired
	public ClientController(final ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	@GetMapping("/getAll")
	public Collection<Client> getAllClients() {
		return clientRepository.findAll().stream()
				.collect(Collectors.toList());
	}

}
