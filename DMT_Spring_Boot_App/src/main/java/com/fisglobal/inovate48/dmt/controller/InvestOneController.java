package com.fisglobal.inovate48.dmt.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Debasis.Mishra
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/rest")
public class InvestOneController {

	@GetMapping("/messaging/latest/{customer}/account , method = RequestMethod.POST")
	public void addEntity(@RequestBody final String jsonRequest) {
		try {
			System.out.println("Insert successfully in InvestOne : \n" + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(jsonRequest));
		} catch (final JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
