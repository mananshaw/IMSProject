package com.manan.springcloud;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.manan.springcloud.dto.ProductDto;
import com.manan.springcloud.entity.Product;
import com.manan.springcloud.response.Response;


@RunWith(SpringRunner.class)
@SpringBootTest
class PurchaseserviceApplicationTests {
	
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext context;
	
	ObjectMapper om = new ObjectMapper();
	
	@Before
	public void setup() {
		
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		
	}

	
	@Test
	public void createProductTest() throws Exception {
		
		Product productDto = new Product();
		productDto.setId(4);
		productDto.setProductname("car");
		productDto.setProducttype("Manufacturing");
		productDto.setStock(120);
		productDto.setSuppliername("Tata Motors");
		productDto.setPrice(new BigDecimal("1230"));
		
		String jsonRequest = om.writeValueAsString(productDto);
		
		MvcResult result = mockMvc.perform(
				post("/purchase/save").content(jsonRequest)
		                    .content(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk())
                             .andReturn();
		
		String resultContent = result.getResponse().getContentAsString();
		
		Response response = om.readValue(resultContent, Response.class);
		
		Assert.assertTrue(response.isStatus() == Boolean.TRUE);
		
		
	}
	
	
	@Test
	public void getProductTest() throws Exception {
		
		
		MvcResult result = mockMvc.perform(
				get("/purchase//findAll")
		                    .content(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk())
                             .andReturn();
		
		String resultContent = result.getResponse().getContentAsString();
		
		Response response = om.readValue(resultContent, Response.class);
		
		Assert.assertTrue(response.isStatus() == Boolean.TRUE);
		
		
	}
	
	
}
