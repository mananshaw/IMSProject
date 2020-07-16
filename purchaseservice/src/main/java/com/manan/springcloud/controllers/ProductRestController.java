package com.manan.springcloud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.manan.springcloud.repo.ProductRepo;





@RestController

@RequestMapping("/purchase")
public class ProductRestController {

	@Autowired
	ProductRepo productrepo;
	@Autowired
	Productconverter converter;
	
	@PostMapping(value="/save")
	public ProductDto createProduct(@RequestBody ProductDto dto) {
		
		Product product = converter.dtoToEntity(dto);
		product = productrepo.save(product);
		
		return converter.entityToDto(product);
		
	}
	
	
	@GetMapping(value="/findAll")
	public List<ProductDto> getProduct()  {
		   
		List<Product> product = productrepo.findAll();
		
		return converter.entityToDto(product);
		
	}
	
	@GetMapping(value="/findbyid/{id}")
	public ProductDto getProduct(@PathVariable("id") int id)  {
		
		Product product= productrepo.findById(id);
		
		return converter.entityToDto(product);
		
	}
	
	

	@PutMapping(value="/update/{id}")
	public ProductDto updateProduct(@PathVariable ("id") int id,@RequestBody ProductDto dto) {
			     
		 Product product = converter.dtoToEntity(dto);
		
		     
		 product = productrepo.save(product);
		  
		 return converter.entityToDto(product);
		
	}
	
	@DeleteMapping(value="remove/{id}")
	
	 public void deleteProduct(@PathVariable("id") int id) {
		
		 productrepo.deleteById(id);
		
	}
	
	
}
