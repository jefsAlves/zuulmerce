package com.alvesjefs.zuulmerce.services;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alvesjefs.zuulmerce.domain.Computers;
import com.alvesjefs.zuulmerce.domain.Orders;
import com.alvesjefs.zuulmerce.dto.ComputersDTO;
import com.alvesjefs.zuulmerce.dto.OrdersDTO;
import com.alvesjefs.zuulmerce.enums.OrderStatus;
import com.alvesjefs.zuulmerce.repositories.ComputersRepository;
import com.alvesjefs.zuulmerce.repositories.OrdersRepository;
import com.alvesjefs.zuulmerce.services.exceptions.IdNotFoundException;

@Service
public class OrdersService {

	@Autowired
	private OrdersRepository ordersRepository;

	@Autowired
	private ComputersRepository computersRepository;

	@Transactional(readOnly = true)
	public Orders findById(Long id) {
		Optional<Orders> findId = ordersRepository.findById(id);
		return findId.orElseThrow(() -> new IdNotFoundException("Id not found!"));
	}

	@Transactional(readOnly = true)
	public List<OrdersDTO> findAll() {
		List<Orders> findAll = ordersRepository.findAll();
		return findAll.stream().map(x -> new OrdersDTO(x)).collect(Collectors.toList());
	}

	@Transactional
	public OrdersDTO insertOrder(OrdersDTO ordersDTO) {
		Random random = new Random();
		Orders orders = new Orders(null, Instant.now(), OrderStatus.PENDING, random.nextInt(25));
		for (ComputersDTO comp : ordersDTO.getComputers()) {
			Computers computers = computersRepository.getOne(comp.getId());
			orders.getComputers().add(computers);
		}

		orders = ordersRepository.save(orders);
		return new OrdersDTO(orders);
	}

	@Transactional
	public OrdersDTO updateOrder(Long id) {
		Orders orders = ordersRepository.getOne(id);
		orders.setOrderStatus(OrderStatus.DELIVERED);
		orders = ordersRepository.save(orders);
		return new OrdersDTO(orders);
	}
}
