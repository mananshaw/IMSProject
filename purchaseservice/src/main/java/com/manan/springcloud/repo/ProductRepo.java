package com.manan.springcloud.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manan.springcloud.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

	
	Product findByProductname(String productname);
	
	Product findById(int id);
}
