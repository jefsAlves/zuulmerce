package com.alvesjefs.zuulmerce.dto;

import java.io.Serializable;

import com.alvesjefs.zuulmerce.domain.Monitor;

public class MonitorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private String brand;
	private Double price;

	public MonitorDTO() {
	}

	public MonitorDTO(String name, String brand, Double price) {
		this.name = name;
		this.brand = brand;
		this.price = price;
	}

	public MonitorDTO(Monitor monitor) {
		name = monitor.getName();
		brand = monitor.getBrand();
		price = monitor.getPrice();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
