package com.fisglobal.inovate48.dmt.controller;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fisglobal.inovate48.dmt.entity.Product;
import com.fisglobal.inovate48.dmt.repository.ProductRepository;

/**
 * @author Debasis.Mishra
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/product")
public class ProductController {

	private final ProductRepository productRepository;

	@Autowired
	public ProductController(final ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@GetMapping("/getAll")
	public Collection<Product> getAllProducts() {
		return productRepository.findAll().stream()
				.collect(Collectors.toList());
	}

	@GetMapping("/getProductForClient/{clientId}")
	public List<Product> getAllProductsForClient(@PathVariable("clientId") final long id) {
		return productRepository.getProductsForClient(id);
	}
}
