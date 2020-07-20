package com.manan.springcloud.servicetest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.manan.springcloud.controllers.ProductRestController;
import com.manan.springcloud.converter.Productconverter;
import com.manan.springcloud.dto.ProductDto;
import com.manan.springcloud.entity.Product;
import com.manan.springcloud.exception.UserServiceException;
import com.manan.springcloud.repo.ProductRepo;
import static org.junit.Assert.assertThrows;


class ProductRestServiceTest {
	
	@InjectMocks
	ProductRestController productRestController;
	
	
	@Mock
	ProductRepo   productrepo;
	
	
	@Spy
	Productconverter converter;
	
	private Product product = new Product();
	private ProductDto productDto = new ProductDto();
	

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	

	@Test
	final void testGetProduct() throws Exception {
		
		
		
		product.setId(1);
		product.setProductname("Cement");
		product.setStock(10);
		product.setSuppliername("Manan");
		product.setPrice(new BigDecimal("12"));
		product.setProducttype("raw");
		
		
		
		when(productrepo.findById(anyInt())).thenReturn(product);
	
		productDto =	productRestController.getProduct(1);

		
		assertNotNull(productDto);
		assertEquals("Cement", productDto.getProductname());
		
	}
	
	@Test
	final void testcreateProduct( ) {
		
		product.setId(1);
		product.setProductname("Cement");
		product.setStock(10);
		product.setSuppliername("Manan");
		product.setPrice(new BigDecimal("12"));
		product.setProducttype("raw");
		
		when(productrepo.save(anyObject())).thenReturn(product);
		
		
		
		productDto = productRestController.createProduct(productDto);
		
		assertNotNull(productDto);
		
	}
	
	
	
	
	
	
	
	 @Test
	final void testUpdateProduct( ) {
		
		 productDto.setId(1);
		 productDto.setProductname("Cement");
		 productDto.setStock(10);
		 productDto.setSuppliername("Manan");
		 productDto.setPrice(new BigDecimal("12"));
		 productDto.setProducttype("raw");
		
		when(productrepo.findById(anyInt())).thenReturn(product);
		
	//	when(converter.dtoToEntity(productDto)).thenReturn(product);
		
		
		productDto = productRestController.updateProduct(1, productDto);
		
		assertNotNull(product);
		
	} 
	 
	 @Test
	 final void GetProdductByIdTest() {
		 
		 product.setId(1);
		 product.setProductname("Cement");
		 product.setStock(10);
		 product.setSuppliername("Manan");
		 product.setPrice(new BigDecimal("12"));
		 product.setProducttype("raw");
		 
	
		 when(productrepo.findById(anyInt())).thenReturn(product);
		 productDto = productRestController.getProduct(1);
		 
		 assertNotNull(productDto);
		 assertEquals("Cement", productDto.getProductname());
		 
	 }
	 
	 
	
	

}
