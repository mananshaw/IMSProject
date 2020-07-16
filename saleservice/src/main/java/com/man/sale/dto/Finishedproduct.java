package com.man.sale.dto;

import java.math.BigDecimal;

public class Finishedproduct {

	
	private int id;
	
	private String name;
	private String description;
	private long stock;
	private BigDecimal price;
	
	
	public Finishedproduct() {}
	
	public Finishedproduct(int id, String name, String description, long stock, BigDecimal price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.stock = stock;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getStock() {
		return stock;
	}
	public void setStock(long stock) {
		this.stock = stock;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
