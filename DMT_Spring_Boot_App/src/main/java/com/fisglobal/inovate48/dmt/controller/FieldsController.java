package com.fisglobal.inovate48.dmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fisglobal.inovate48.dmt.entity.Fields;
import com.fisglobal.inovate48.dmt.repository.FieldsRepository;

/**
 * @author Debasis.Mishra
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/fields")
public class FieldsController {

	private final FieldsRepository fieldsRepository;

	@Autowired
	public FieldsController(final FieldsRepository fieldsRepository) {
		this.fieldsRepository = fieldsRepository;
	}

	@GetMapping("/getFieldsForModule/{moduleId}")
	public List<Fields> getFieldsForModule(@PathVariable("moduleId") final long moduleId) {
		return fieldsRepository.getFieldsForModule(moduleId);
	}

}