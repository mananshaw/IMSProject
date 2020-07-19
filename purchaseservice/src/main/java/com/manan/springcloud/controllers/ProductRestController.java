package com.manan.springcloud.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manan.springcloud.converter.Productconverter;
import com.manan.springcloud.dto.ProductDto;
import com.manan.springcloud.entity.Product;
import com.manan.springcloud.exception.UserServiceException;
import com.manan.springcloud.repo.ProductRepo;
import com.manan.springcloud.response.Response;

@RestController

@RequestMapping("/purchase")
public class ProductRestController {

	@Autowired
	ProductRepo productrepo;
	@Autowired
	Productconverter converter;

	private static final Logger logger = LoggerFactory.getLogger(ProductRestController.class);

	@PostMapping(value = "/save")
	public ProductDto createProduct(@RequestBody ProductDto dto) {

		logger.info("Inside postmapping createproduct method");

		Product product = converter.dtoToEntity(dto);
		
		product = productrepo.save(product);

		logger.warn("Inside postmapping createproduct method");
		
		return converter.entityToDto(product);

	}

	
	  @GetMapping(value = "/findAll") 
	  
	  public Response getProduct() {
	 
	 logger.info("Inside getmapping request call, getProduct method");
	 
	  List<Product> product = productrepo.findAll();
	  		 
	  
	  logger.error("Inside getmapping request call, getProduct method");
        
	  return new Response("records count: " +product.size(),Boolean.TRUE);
	  }
	 

	@PutMapping(value = "/{id}")
	@CachePut(value = "product", key = "#id")
	public ProductDto updateProduct(@PathVariable("id") int id, @RequestBody ProductDto dto)  {

		logger.info("Inside putmapping by id request call, updateProduct method");

		Product product = converter.dtoToEntity(dto);
					
		

		 productrepo.save(product);

		logger.error("Inside putmapping by id request call, updateProduct method");

		return converter.entityToDto(product);

	}

	@DeleteMapping(value = "{id}")
	@CacheEvict(value = "product", key = "id")
	public void deleteProduct(@PathVariable("id") int id) {

		logger.info("Inside deletemapping by id request call, deleteProduct method");
        
	
		
		productrepo.deleteById(id);

		logger.info("Inside deletemapping by id request call, deleteProduct method");

	}

	@GetMapping(value = "{id}")
	@Cacheable(value = "product", key = "#id")
	public ProductDto getProduct(@PathVariable("id") int id) {

		logger.info("Inside getmapping by id request call, getProduct method");

		Product product = productrepo.findById(id);
			

		logger.error("Inside getmapping by id request call, getProduct method");

		return converter.entityToDto(product);

	}

}
