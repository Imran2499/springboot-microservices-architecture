package com.cg.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.order.dto.OrderProductDto;
import com.cg.order.exception.ResourceNotFoundException;
import com.cg.order.model.Order;
import com.cg.order.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService service;

	// CREATE
	@PostMapping
	public Order create(@RequestBody Order order) {
		return service.createOrder(order);
	}

	// READ (All)
	@GetMapping
	public List<Order> getAll() {
		return service.getAllOrders();
	}

	// READ (SINGLE)
	@GetMapping("/{id}")
	public Order getById(@PathVariable Long id) throws ResourceNotFoundException {
		return service.getOrderById(id);
	}

	// UPDATE
	@PutMapping("/{id}")
	public Order update(@PathVariable Long id, @RequestBody Order order) throws ResourceNotFoundException {
		return service.updateOrder(id, order);
	}

	// DELETE
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		service.deleteOrder(id);
		return "Order deleted successfully" + id;
	}

	@GetMapping("/withProduct/{orderId}")
	public OrderProductDto getOrderWithProduct(@PathVariable Long orderId) throws ResourceNotFoundException {
	    return service.getOrderWithProductUsingRestClient(orderId);
	}
}
