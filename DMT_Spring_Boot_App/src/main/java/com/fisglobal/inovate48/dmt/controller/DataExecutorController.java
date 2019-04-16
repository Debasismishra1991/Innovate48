/**
 *
 */
package com.fisglobal.inovate48.dmt.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fisglobal.inovate48.dmt.entity.Fields;
import com.fisglobal.inovate48.dmt.entity.LkClientProduct;
import com.fisglobal.inovate48.dmt.entity.Mapping;
import com.fisglobal.inovate48.dmt.entity.MappingCompositePrimaryKey;
import com.fisglobal.inovate48.dmt.entity.ProductModule;
import com.fisglobal.inovate48.dmt.repository.FieldsRepository;
import com.fisglobal.inovate48.dmt.repository.LkClientProductRepository;
import com.fisglobal.inovate48.dmt.repository.MappingRepository;
import com.fisglobal.inovate48.dmt.repository.ProductModuleRepository;

/**
 *
 * @author Debasis.Mishra
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/execute")
public class DataExecutorController {

	private final ProductModuleRepository productModuleRepository;
	private final MappingRepository mappingRepository;
	private final LkClientProductRepository lkClientProductRepository;
	private final FieldsRepository fieldsRepository;

	private final ObjectMapper jacksonMapper = new ObjectMapper();

	@Autowired
	public DataExecutorController(final ProductModuleRepository productModuleRepository,
			final MappingRepository mappingRepository, final LkClientProductRepository lkClientProductRepository,
			final FieldsRepository fieldsRepository) {
		this.mappingRepository = mappingRepository;
		this.lkClientProductRepository = lkClientProductRepository;
		this.productModuleRepository = productModuleRepository;
		this.fieldsRepository = fieldsRepository;
	}

	@SuppressWarnings("unused")
	@RequestMapping(value = "/process/{productId}/{clientId}/{moduleId}", method = RequestMethod.POST)
	public ResponseEntity<List<HashMap<String, Object>>> processExecutor(@RequestBody final String jsonRequest,
			@PathVariable("productId") final long productId, @PathVariable("clientId") final long clientId,
			@PathVariable("moduleId") final long moduleId) {
		final LkClientProduct lkClientProduct = lkClientProductRepository.getClientProductID(productId, clientId);
		final ProductModule productModule = productModuleRepository.getOne(moduleId);
		final List<Mapping> mappingList = new ArrayList(
				mappingRepository.getAllMappings(lkClientProduct.getCliProId(), moduleId));
		final MappingCompositePrimaryKey mappingCompositePK = new MappingCompositePrimaryKey(
				lkClientProduct.getCliProId(), moduleId);

		final List<HashMap<String, Object>> outPutRequestList = new ArrayList<HashMap<String, Object>>();
		try {
			final List<Map<String, Object>> inputRequestMap = jacksonMapper.readValue(jsonRequest,
					new TypeReference<List<Map<String, Object>>>() {
			});
			inputRequestMap.forEach(item -> {
				final HashMap<String, Object> outPutRequestObj = new HashMap<>();
				item.forEach((key, value) -> {
					Mapping mappingObjFound = null;
					for (final Mapping mapping : mappingList) {
						if (mapping.getFieldValue().equalsIgnoreCase(key)) {
							mappingObjFound = mapping;
							break;
						}
					}
					if (null != mappingObjFound) {
						final Fields field = mappingObjFound.getField();
						outPutRequestObj.put(field.getFieldName(), value);
					}
				});
				outPutRequestList.add(outPutRequestObj);
			});
			System.out.println(outPutRequestList);
		} catch (final IOException e) {
			System.out.println("Error");
		}
		final InvestOneController investOneController = new InvestOneController();
		investOneController.addEntity(jsonRequest);
		return new ResponseEntity<List<HashMap<String, Object>>>(outPutRequestList, HttpStatus.CREATED);
	}

}
