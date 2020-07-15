package com.manan.springcloud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manan.springcloud.model.Product;
import com.manan.springcloud.repo.ProductRepo;



@RestController
@RequestMapping("/ims/api")
public class ProductRestController {

	@Autowired
	ProductRepo productrepo;
	
	@PostMapping(value="products")
	public Product createProduct(@RequestBody Product product) {
		
		return productrepo.save(product);
		
	}
	
	@GetMapping(value="/products/{productname}")
	public Product getProduct(@PathVariable("productname") String productname)  {
		
		return productrepo.findByProductname(productname);
		
	}
	
	@GetMapping(value="/orderid/{id}")
	public Product getProduct(@PathVariable("id") int id)  {
		
		return productrepo.findById(id);
		
	}
	
	
}
