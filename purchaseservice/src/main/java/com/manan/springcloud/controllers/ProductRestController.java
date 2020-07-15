package com.manan.springcloud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.manan.springcloud.model.Product;
import com.manan.springcloud.repo.ProductRepo;



@RestController
@RequestMapping("/ims/api")
public class ProductRestController {

	@Autowired
	ProductRepo productrepo;
	
	@RequestMapping(value="products", method=RequestMethod.POST)
	public Product createProduct(@RequestBody Product product) {
		
		return productrepo.save(product);
		
	}
	
	@RequestMapping(value="/products/{productname}", method = RequestMethod.GET)
	public Product getProduct(@PathVariable("productname") String productname)  {
		
		return productrepo.findByProductname(productname);
		
	}
	
	@RequestMapping(value="/orderid/{id}", method = RequestMethod.GET)
	public Product getProduct(@PathVariable("id") int id)  {
		
		return productrepo.findById(id);
		
	}
	
	
}
