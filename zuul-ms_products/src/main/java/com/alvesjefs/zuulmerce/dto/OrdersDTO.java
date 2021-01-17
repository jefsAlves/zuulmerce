package com.alvesjefs.zuulmerce.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.alvesjefs.zuulmerce.domain.Orders;

public class OrdersDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Instant moment;
	private Integer orderNumber;

	private Set<ComputersDTO> computers = new HashSet<>();

	public OrdersDTO() {
	}

	public OrdersDTO(Long id, Instant moment, Integer orderNumber) {
		this.id = id;
		this.moment = moment;
		this.orderNumber = orderNumber;
	}

	public OrdersDTO(Orders orders) {
		id = orders.getId();
		moment = orders.getMoment();
		orderNumber = orders.getOrderNumber();
		computers = orders.getComputers().stream().map(x -> new ComputersDTO(x)).collect(Collectors.toSet());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setSerieNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Set<ComputersDTO> getComputers() {
		return computers;
	}

	public Double getTotal() {
		double sum = 0.0;
		for (ComputersDTO comp : computers) {
			sum += comp.subTotal();
		}
		return sum;
	}

}
