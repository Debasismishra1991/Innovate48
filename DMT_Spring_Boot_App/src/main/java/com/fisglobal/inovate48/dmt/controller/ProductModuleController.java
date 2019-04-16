package com.fisglobal.inovate48.dmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fisglobal.inovate48.dmt.entity.ProductModule;
import com.fisglobal.inovate48.dmt.repository.ProductModuleRepository;

/**
 * @author Debasis.Mishra
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/module")
public class ProductModuleController {

	private final ProductModuleRepository productModuleRepository;

	@Autowired
	public ProductModuleController(final ProductModuleRepository productModuleRepository) {
		this.productModuleRepository = productModuleRepository;
	}

	@GetMapping("/getModulesForProduct/{productId}")
	public List<ProductModule> getModulesForProduct(@PathVariable("productId") final long id) {
		return productModuleRepository.getModulesForProduct(id);
	}

}