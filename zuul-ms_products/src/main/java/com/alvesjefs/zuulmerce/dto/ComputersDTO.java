package com.alvesjefs.zuulmerce.dto;

import java.io.Serializable;

import com.alvesjefs.zuulmerce.domain.Computers;

public class ComputersDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String description;
	private String brand;
	private String model;
	private Integer quantity;
	private Double price;

	public ComputersDTO() {
	}

	public ComputersDTO(Long id, String name, String description, String brand, String model, Integer quantity,
			Double price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.brand = brand;
		this.model = model;
		this.quantity = quantity;
		this.price = price;
	}

	public ComputersDTO(Computers computers) {
		id = computers.getId();
		name = computers.getName();
		description = computers.getDescription();
		brand = computers.getBrand();
		model = computers.getModel();
		quantity = computers.getQuantity();
		price = computers.getPrice();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double subTotal() {
		return quantity * price;
	}

}
