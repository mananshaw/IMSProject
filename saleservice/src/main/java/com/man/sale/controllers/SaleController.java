package com.man.sale.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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
	
	private static final Logger logger = LoggerFactory.getLogger(SaleController.class);

	
	@GetMapping(value="/saleid/{id}")
	//@Cacheable(value="product",key="id")
	public  ResponseEntity<FinishedproductDto> getSaleproduct(@PathVariable ("id") int id ) {
		
		System.out.println("Rest Template Test");
		
		restTemplate.getInterceptors().add(
				  new BasicAuthorizationInterceptor("admin", "password"));
		
		logger.error("inside SaleController / getSaleproduct method");
		
		//return restTemplate.getForObject("http://localhost:8083/production/findbyid/1", FinishedproductDto.class);
	
		return restTemplate.exchange(
				  "http://localhost:8083/production/findbyid/" +id, 
				  HttpMethod.GET, null, FinishedproductDto.class);	 
		 
	       
	}

}
