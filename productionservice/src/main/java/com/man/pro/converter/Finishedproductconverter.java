package com.man.pro.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


import com.man.pro.dto.FinishedproductDto;
import com.man.pro.entity.Finishedproduct;


@Component
public class Finishedproductconverter {
	
	private static final Logger logger = LoggerFactory.getLogger(Finishedproductconverter.class);	
	
public FinishedproductDto entityToDto(Finishedproduct finishedproduct) {
		
	FinishedproductDto dto = new FinishedproductDto();
	
	
	
	logger.error("inside entityToDto method");
	
		dto.setId(finishedproduct.getId());
		dto.setName(finishedproduct.getName());
		dto.setDescription(finishedproduct.getDescription());
		
		dto.setStock(finishedproduct.getStock());
		dto.setPrice(finishedproduct.getPrice());
		
		logger.error("inside entityToDto method");	
		return dto;
	}
	
	public Finishedproduct dtoToEntity(FinishedproductDto dto) {
		
		Finishedproduct finishedproduct = new Finishedproduct();
		
		logger.error("inside dtoToEntity method");
		
		finishedproduct.setId(dto.getId());
		finishedproduct.setName(dto.getName());
		finishedproduct.setDescription(dto.getDescription());
		
		logger.info("inside dtoToEntity method");
		
		finishedproduct.setStock(dto.getStock());
		finishedproduct.setPrice(dto.getPrice());
		
		return finishedproduct;
		
	}
	
public List<FinishedproductDto> entityToDto(List<Finishedproduct> finishedproduct) {
		
	logger.error("inside list entityToDto method");
		return finishedproduct.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}


public List<Finishedproduct> dtoToEntity(List<FinishedproductDto> dto) {
	
	logger.error("inside list dtoToEntity method");
	
	return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
}	



}
