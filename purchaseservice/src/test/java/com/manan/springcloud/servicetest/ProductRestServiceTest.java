package com.manan.springcloud.servicetest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.manan.springcloud.controllers.ProductRestController;
import com.manan.springcloud.converter.Productconverter;
import com.manan.springcloud.dto.ProductDto;
import com.manan.springcloud.entity.Product;
import com.manan.springcloud.repo.ProductRepo;



class ProductRestServiceTest {
	@InjectMocks
	ProductRestController productRestController;
	
	@Mock
	ProductRepo productrepo;
	@Mock
	Productconverter converter;
	

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetProduct() {
		
		Product product = new Product();
		product.setId(1);
		product.setProductname("Cement");
	    product.setStock(10);
	    product.setSuppliername("Manan");
	    product.setPrice(new BigDecimal("12"));
	    product.setProducttype("raw");
		
		
		
		when(productrepo.findById(anyInt())).thenReturn(product);
		
		ProductDto productDto =	productRestController.getProduct(1);
		
		
		
		assertNotNull(productDto);
		assertEquals("Manan", productDto.getSuppliername());
		
	}

}
