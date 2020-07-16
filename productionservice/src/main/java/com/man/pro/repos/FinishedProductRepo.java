package com.man.pro.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.man.pro.entity.Finishedproduct;

public interface FinishedproductRepo extends JpaRepository<Finishedproduct, Integer> {

	Finishedproduct findByName(String name);
	Finishedproduct findById(int id);
	
}
