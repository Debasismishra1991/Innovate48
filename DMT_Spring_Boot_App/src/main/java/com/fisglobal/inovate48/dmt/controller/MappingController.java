package com.fisglobal.inovate48.dmt.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fisglobal.inovate48.dmt.entity.LkClientProduct;
import com.fisglobal.inovate48.dmt.entity.Mapping;
import com.fisglobal.inovate48.dmt.entity.MappingCompositePrimaryKey;
import com.fisglobal.inovate48.dmt.entity.ProductModule;
import com.fisglobal.inovate48.dmt.repository.LkClientProductRepository;
import com.fisglobal.inovate48.dmt.repository.MappingRepository;
import com.fisglobal.inovate48.dmt.repository.ProductModuleRepository;

/**
 * @author Debasis.Mishra
 *
 */
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:9099"})
@RestController
@RequestMapping("/mapping")
public class MappingController {

	private final ProductModuleRepository productModuleRepository;
	private final MappingRepository mappingRepository;
	private final LkClientProductRepository lkClientProductRepository;

	@Autowired
	public MappingController(final ProductModuleRepository productModuleRepository,final MappingRepository mappingRepository,final LkClientProductRepository lkClientProductRepository) {
		this.mappingRepository = mappingRepository;
		this.lkClientProductRepository = lkClientProductRepository;
		this.productModuleRepository = productModuleRepository;
	}

	@GetMapping("/getMappingForSpecCliMod/{productId}/{clientId}/{moduleId}")
	public Collection<Mapping> getAllMappings(@PathVariable("productId") final long productId,
			@PathVariable("clientId") final long clientId, @PathVariable("moduleId") final long moduleId) {
		final LkClientProduct lkClientProduct =  lkClientProductRepository.getClientProductID(productId,clientId);
		return mappingRepository.getAllMappings(lkClientProduct.getCliProId(),moduleId);
	}

	@RequestMapping(value= "/saveMappings/{productId}/{clientId}/{moduleId}", method = RequestMethod.POST)
	public ResponseEntity<List<Mapping>> saveMappings(@RequestBody final List<Mapping> mappingList,@PathVariable("productId") final long productId,
			@PathVariable("clientId") final long clientId, @PathVariable("moduleId") final long moduleId) {
		final LkClientProduct lkClientProduct =  lkClientProductRepository.getClientProductID(productId,clientId);
		final ProductModule productModule = productModuleRepository.getOne(moduleId);
		final List<Mapping> mappingListNew = new ArrayList<Mapping>();
		for(final Mapping mappig : mappingList){
			mappig.setLkClientProduct(lkClientProduct);
			mappig.setId(new MappingCompositePrimaryKey(lkClientProduct.getCliProId(), moduleId, mappig.getField().getFieldId()));
			mappig.setModule(productModule);
			mappingRepository.save(mappig);
			mappingListNew.add(mappig);
		}
		return new ResponseEntity<List<Mapping>>(mappingListNew, HttpStatus.CREATED);
	}


}
