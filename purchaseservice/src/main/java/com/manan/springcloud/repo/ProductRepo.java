package com.manan.springcloud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manan.springcloud.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

	
	Product findByProductname(String productname);
	
	Product findById(int id);
}
