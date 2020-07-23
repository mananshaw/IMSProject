package com.man.pro.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.man.pro.converter.Finishedproductconverter;
import com.man.pro.dto.FinishedproductDto;
import com.man.pro.dto.ProductDto;
import com.man.pro.entity.Finishedproduct;
import com.man.pro.repos.FinishedproductRepo;
import com.man.pro.customexception.UserServiceException;


@RestController
@RequestMapping("/production")
public class FinishedproductController {

	@Autowired
	FinishedproductRepo repo;

	@Autowired
	Finishedproductconverter converter;
	
	@Autowired
	Environment env;

	@Autowired
	RestTemplate restTemplate;

	private static final Logger logger = LoggerFactory.getLogger(FinishedproductController.class);


	
	@PostMapping(value = "/save")
	public FinishedproductDto createFinishedProduct(@RequestBody FinishedproductDto dto) {

		Finishedproduct finishedproduct = converter.dtoToEntity(dto);

		logger.error("createFinishProduct method....Error Msg");

		finishedproduct = repo.save(finishedproduct);

		logger.trace("createFinishProduct method.....Trace Msg");
		return converter.entityToDto(finishedproduct);
	}

	
	@GetMapping(value = "/findbyid/{id}")
	@Cacheable(value ="finishedproduct", key="#id")
	public FinishedproductDto getFinishedproduct(@PathVariable("id") int id) {
		
		Finishedproduct finishedproduct = repo.findById(id);

		logger.error("getFinishedproduct method....Error Msg");
		
		if(finishedproduct==null) {throw new UserServiceException("Id not found");}
		return converter.entityToDto(finishedproduct) ;

	}

	@PutMapping(value = "/update/{id}")
	@CachePut(value = "finishedproduct" , key ="#id")
	public FinishedproductDto updateFinishedproduct(@PathVariable("id") int id, @RequestBody FinishedproductDto dto) {

		Finishedproduct finishedproduct = repo.findById(id);
		logger.error("updateFinishedproduct method.....Trace Msg");
		
		if (finishedproduct == null) {
			throw new UserServiceException("No id found for update");
		} else {
			finishedproduct = converter.dtoToEntity(dto);
		}
		
		
		repo.save(finishedproduct);
		logger.trace("updateFinishedproduct  method.....Trace Msg");

		return converter.entityToDto(finishedproduct);
	}

	@GetMapping(value = "{id}")	
	public ResponseEntity<ProductDto> getProduct(@PathVariable("id") int id) {

		logger.info("getProductby id method...");
		logger.error("getProduct method.....Trace Msg");
		
		restTemplate.getInterceptors().add(
				  new BasicAuthorizationInterceptor(env.getProperty("pro.dept.user"), env.getProperty("pro.dept.pass")));
		
		logger.trace("getProduct  method.....Trace Msg");

			
			
			return restTemplate.exchange(env.getProperty("production.get.url") +id, 
					  HttpMethod.GET, null, ProductDto.class);
	
	}

}