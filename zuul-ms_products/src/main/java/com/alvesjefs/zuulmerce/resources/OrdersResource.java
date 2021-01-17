package com.alvesjefs.zuulmerce.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

	@PostMapping
	public ResponseEntity<OrdersDTO> insertOrder(OrdersDTO ordersDTO) {
		OrdersDTO insertOrder = ordersService.insertOrder(ordersDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ordersDTO.getId())
				.toUri();
		return ResponseEntity.created(uri).body(insertOrder);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<OrdersDTO> updateOrder(@PathVariable Long id) {
		OrdersDTO updateOrder = ordersService.updateOrder(id);
		return ResponseEntity.noContent().build();
	}
}
