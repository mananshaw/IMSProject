package com.manan.springcloud.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.manan.springcloud.dto.ProductDto;
import com.manan.springcloud.entity.Product;

@Component
public class Productconverter {

	private static final Logger logger = LoggerFactory.getLogger(Productconverter.class);

	public  ProductDto entityToDto(Product product) {

		
		ProductDto dto = new ProductDto();

		
		logger.info("inside Productconverter class in entityToDto method ");

		dto.setId(product.getId());
		dto.setProductname(product.getProductname());
		dto.setProducttype(product.getProducttype());

		logger.warn("inside entityToDto method ");

		dto.setSuppliername(product.getSuppliername());
		dto.setStock(product.getStock());
		dto.setPrice(product.getPrice());
		logger.error("inside Productconverter class in entityToDto method ");

		return dto;
	}

	public  Product dtoToEntity(ProductDto dto) {

		Product product = new Product();

		logger.info("inside Productconverter class in dtoToEntity method ");

		product.setId(dto.getId());
		product.setProductname(dto.getProductname());
		product.setProducttype(dto.getProducttype());
		product.setSuppliername(dto.getSuppliername());
		product.setStock(dto.getStock());
		product.setPrice(dto.getPrice());

		logger.error("inside Productconverter class in dtoToEntity method ");

		return product;

	}

	public  List<ProductDto> entityToDto(List<Product> product) {

		logger.warn("inside Productconverter class in dtoToEntity method\\ ");

		return product.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}

	public  List<Product> dtoToEntity(List<ProductDto> dto) {

		logger.warn("inside Productconverter class in dtoToEntity method // ");

		return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}

}
