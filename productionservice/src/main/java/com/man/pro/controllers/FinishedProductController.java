package com.man.pro.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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


@RestController
@RequestMapping("/production")
public class FinishedproductController {

	@Autowired
	FinishedproductRepo repo;

	@Autowired
	Finishedproductconverter converter;

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
		
		
		return converter.entityToDto(finishedproduct) ;

	}

	@PutMapping(value = "/update/{id}")
	@CachePut(value = "finishedproduct" , key ="#id")
	public FinishedproductDto updateFinishedproduct(@PathVariable("id") int id, @RequestBody FinishedproductDto dto) {

		Finishedproduct finishedproduct = converter.dtoToEntity(dto);
		logger.error("updateFinishedproduct method.....Trace Msg");
		
		repo.save(finishedproduct);
		logger.trace("updateFinishedproduct  method.....Trace Msg");

		return converter.entityToDto(finishedproduct);
	}

	@GetMapping(value = "{id}")
	@Cacheable(value = "product" , key = "#id")
	public ProductDto getProduct(@PathVariable("id") int id) {

		logger.error("getProduct method.....Trace Msg");
		logger.trace("getProduct  method.....Trace Msg");
		return restTemplate.getForObject("http://localhost:8081/purchase/findbyid/" + id, ProductDto.class);
	}

}