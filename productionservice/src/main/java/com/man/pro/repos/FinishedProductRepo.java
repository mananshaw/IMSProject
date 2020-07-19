package com.man.pro.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.man.pro.entity.Finishedproduct;

@Repository
public interface FinishedproductRepo extends JpaRepository<Finishedproduct, Integer> {

	Finishedproduct findByName(String name);
	Finishedproduct findById(int id);
	
    
	
}
