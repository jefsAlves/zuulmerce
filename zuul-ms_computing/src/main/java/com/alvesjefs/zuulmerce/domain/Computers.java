package com.alvesjefs.zuulmerce.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "TB_COMPUTERS")
public class Computers implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private String color;
	private String serieNumber;
	private String brand;
	private String model;
	private Double price;
	private Double heigth;
	private Double width;

	public Computers() {
	}

	public Computers(Long id, String name, String description, String color, String serieNumber, String brand,
			String model, Double price, Double heigth, Double width) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.color = color;
		this.serieNumber = serieNumber;
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.heigth = heigth;
		this.width = width;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@JoinColumn(unique = true)
	public String getSerieNumber() {
		return serieNumber;
	}

	public void setSerieNumber(String serieNumber) {
		this.serieNumber = serieNumber;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getHeigth() {
		return heigth;
	}

	public void setHeigth(Double heigth) {
		this.heigth = heigth;
	}

	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
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
		Computers other = (Computers) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Computers [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append(", color=");
		builder.append(color);
		builder.append(", serieNumber=");
		builder.append(serieNumber);
		builder.append(", brand=");
		builder.append(brand);
		builder.append(", model=");
		builder.append(model);
		builder.append(", price=");
		builder.append(price);
		builder.append(", heigth=");
		builder.append(heigth);
		builder.append(", width=");
		builder.append(width);
		builder.append("]");
		return builder.toString();
	}

}
