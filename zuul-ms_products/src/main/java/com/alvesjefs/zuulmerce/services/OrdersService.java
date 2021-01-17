package com.alvesjefs.zuulmerce.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alvesjefs.zuulmerce.domain.Orders;
import com.alvesjefs.zuulmerce.dto.OrdersDTO;
import com.alvesjefs.zuulmerce.repositories.OrdersRepository;
import com.alvesjefs.zuulmerce.services.exceptions.IdNotFoundException;

@Service
public class OrdersService {

	@Autowired
	private OrdersRepository ordersRepository;

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
}
