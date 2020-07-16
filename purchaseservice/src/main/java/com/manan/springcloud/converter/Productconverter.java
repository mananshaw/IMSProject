package com.manan.springcloud.converter;


import java.util.stream.Collectors;
import java.util.*;


import org.springframework.stereotype.Component;

import com.manan.springcloud.dto.ProductDto;
import com.manan.springcloud.entity.Product;



@Component
public class Productconverter {
	
	public ProductDto entityToDto(Product product) {
		
		ProductDto dto = new ProductDto();
		
		dto.setId(product.getId());
		dto.setProductname(product.getProductname());
		dto.setProducttype(product.getProducttype());
		dto.setSuppliername(product.getSuppliername());
		dto.setStock(product.getStock());
		dto.setPrice(product.getPrice());
		return dto;
	}
	
	public Product dtoToEntity(ProductDto dto) {
		
		Product product = new Product();
		
		product.setId(dto.getId());
		product.setProductname(dto.getProductname());
		product.setProducttype(dto.getProducttype());
		product.setSuppliername(dto.getSuppliername());
		product.setStock(dto.getStock());
		product.setPrice(dto.getPrice());
		
		return product;
		
	}
	
public List<ProductDto> entityToDto(List<Product> product) {
		
		
		return product.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}


public List<Product> dtoToEntity(List<ProductDto> dto) {
	
	
	return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
}	
	


}
