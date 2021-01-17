package com.alvesjefs.zuulmerce.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ORDERS")
public class Orders implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant moment;
	private Integer orderNumber;

	@ManyToMany
	@JoinTable(
	name = "TB_ORDERS_COMPUTERS",
	joinColumns = @JoinColumn(name = "ORDER_ID"),
	inverseJoinColumns = @JoinColumn(name = "COMPUTER_ID"))
	private Set<Computers> computers = new HashSet<>();

	public Orders() {
	}

	public Orders(Long id, Instant moment, Integer orderNumber) {
		this.id = id;
		this.moment = moment;
		this.orderNumber = orderNumber;
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

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Set<Computers> getComputers() {
		return computers;
	}
	
	public Double getTotal() {
		double sum = 0.0;
		for(Computers comp : computers) {
			sum += comp.getSubTotal();
		}

		return sum;
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
		Orders other = (Orders) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Products [id=");
		builder.append(id);
		builder.append(", moment=");
		builder.append(moment);
		builder.append(", orderNumber=");
		builder.append(orderNumber);
		builder.append("]");
		return builder.toString();
	}

}
