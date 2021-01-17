package com.alvesjefs.zuulmerce.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alvesjefs.zuulmerce.domain.Orders;
import com.alvesjefs.zuulmerce.dto.OrdersDTO;
import com.alvesjefs.zuulmerce.services.OrdersService;

@RestController
@RequestMapping(value = "api/orders")
public class OrdersResource {

	@Autowired
	private OrdersService ordersService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Orders> findById(@PathVariable Long id) {
		Orders findId = ordersService.findById(id);
		return ResponseEntity.ok().body(findId);
	}

	@GetMapping
	public ResponseEntity<List<OrdersDTO>> findAll(OrdersDTO ordersDTO) {
		List<OrdersDTO> findAll = ordersService.findAll();
		return ResponseEntity.ok().body(findAll);
	}
}
