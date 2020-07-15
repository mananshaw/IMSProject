package com.man.pro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.man.pro.model.Finishedproduct;
import com.man.pro.repos.FinishedProductRepo;

@RestController
@RequestMapping("/ims/finish")
public class FinishedProductController {
	
	@Autowired
	FinishedProductRepo repo;
	
	@PostMapping(value="products")
	public Finishedproduct createFinishedProduct(@RequestBody  Finishedproduct finishedproduct) {
		 
		return repo.save(finishedproduct);
	}
	
	
	
	@GetMapping(value="/products/{name}") 
	public Finishedproduct getFinishedproduct(@PathVariable ("name") String name)	{
		
		return repo.findByName(name);
		
	}
	
	
	@PutMapping(value="/products/{id}")
	public Finishedproduct updateFinishedproduct(@PathVariable ("id") int id, @RequestBody Finishedproduct finishedproduct ) {
    
		finishedproduct.setStock((finishedproduct.getStock() + repo.findById(id).getStock() ));
		
	 return repo.save(finishedproduct);
}
}