package com.man.sale.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.man.sale.dto.FinishedproductDto;

@RestController
@RequestMapping("/sale")
public class SaleController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	Environment env;
	
	private static final Logger logger = LoggerFactory.getLogger(SaleController.class);

	
	@GetMapping(value="/{id}")
	public  ResponseEntity<FinishedproductDto> getSaleproduct(@PathVariable ("id") int id ) {
		
		
		restTemplate.getInterceptors().add(
				  new BasicAuthorizationInterceptor(env.getProperty("sale.dept.user"), env.getProperty("sale.dept.pass")));
		
		logger.error("inside SaleController / getSaleproduct method");
		
		
		logger.info("Test getSaleproduct method");
		
		
		return restTemplate.exchange(env.getProperty("production.get.url") +id, 
				  HttpMethod.GET, null, FinishedproductDto.class);
		 
	       
	}

}
