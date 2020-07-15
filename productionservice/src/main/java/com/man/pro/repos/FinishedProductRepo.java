package com.man.pro.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.man.pro.model.Finishedproduct;

public interface FinishedProductRepo extends JpaRepository<Finishedproduct, Integer> {

	Finishedproduct findByName(String name);
	Finishedproduct findById(int id);
	
}
