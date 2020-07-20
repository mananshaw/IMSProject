package com.man.pro.servicetestcase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.man.pro.controllers.FinishedproductController;
import com.man.pro.converter.Finishedproductconverter;
import com.man.pro.dto.FinishedproductDto;
import com.man.pro.entity.Finishedproduct;
import com.man.pro.repos.FinishedproductRepo;

class ProductionServiceTestCase {

	@InjectMocks
	FinishedproductController finishedproductController;

	@Mock
	FinishedproductRepo repo;

	@Spy
	Finishedproductconverter converter;

	private Finishedproduct finishedproduct = new Finishedproduct();
	private FinishedproductDto finishedproductDto = new FinishedproductDto();

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	final void testGetFinishedProduct() throws Exception {

		finishedproduct.setId(1);
		finishedproduct.setName("Cement");
		finishedproduct.setStock(10);
		finishedproduct.setDescription("Raw material");
		finishedproduct.setPrice(new BigDecimal("12"));

		when(repo.findById(anyInt())).thenReturn(finishedproduct);

		finishedproductDto = finishedproductController.getFinishedproduct(1);

		assertNotNull(finishedproductDto);
		assertEquals("Cement", finishedproductDto.getName());

	}

	@Test
	final void testcreateFinishedProduct() {

		finishedproduct.setId(1);
		finishedproduct.setName("Cement");
		finishedproduct.setStock(10);
		finishedproduct.setDescription("Raw material");
		finishedproduct.setPrice(new BigDecimal("12"));

		when(repo.save(anyObject())).thenReturn(finishedproduct);

		finishedproductDto = finishedproductController.createFinishedProduct(finishedproductDto);

		assertNotNull(finishedproductDto);
		assertEquals("Cement", finishedproductDto.getName());

	}

	@Test
	final void testupdateFinishedproduct() {

		finishedproductDto.setId(1);
		finishedproductDto.setName("Cement");
		finishedproductDto.setStock(10);
		finishedproductDto.setDescription("Raw material");
		finishedproductDto.setPrice(new BigDecimal("12"));

		when(repo.findById(anyInt())).thenReturn(finishedproduct);

		finishedproductDto = finishedproductController.updateFinishedproduct(1, finishedproductDto);

		assertNotNull(finishedproduct);

	} 

}
