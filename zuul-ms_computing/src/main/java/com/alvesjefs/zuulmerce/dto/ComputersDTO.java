package com.alvesjefs.zuulmerce.dto;

import java.io.Serializable;
import java.util.Objects;

import com.alvesjefs.zuulmerce.domain.Computers;

public class ComputersDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String description;
	private Double price;
	private String brand;

	public ComputersDTO() {
	}

	public ComputersDTO(Long id, String name, String description, Double price, String brand) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.brand = brand;
	}

	public ComputersDTO(Computers computers) {
		id = computers.getId();
		name = computers.getName();
		description = computers.getDescription();
		price = computers.getPrice();
		brand = computers.getBrand();
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComputersDTO other = (ComputersDTO) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ComputersDTO [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append(", price=");
		builder.append(price);
		builder.append(", brand=");
		builder.append(brand);
		builder.append("]");
		return builder.toString();
	}

}
