package com.cg.order.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.cg.order.dto.OrderProductDto;
import com.cg.order.dto.Product;
import com.cg.order.exception.ResourceNotFoundException;
import com.cg.order.model.Order;
import com.cg.order.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private RestClient restClient;
	
//	@Autowired
//	private RestTemplate restTemplate;
	@Autowired
	private OrderRepository repository;

	public Order createOrder(Order order) {
		order.setOrderDate(LocalDateTime.now());
		order.setStatus("CREATED");
		return repository.save(order);
	}

	public List<Order> getAllOrders() {
		return repository.findAll();
	}

	public void deleteOrder(Long id) {
		repository.deleteById(id);
	}

	public Order getOrderById(Long id) throws ResourceNotFoundException {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));
	}

	public Order updateOrder(Long id, Order order) throws ResourceNotFoundException {
		Order existing = getOrderById(id);
		existing.setCustomerName(order.getCustomerName());
		existing.setCustomerEmail(order.getCustomerEmail());
		existing.setTotalPrice(order.getTotalPrice());
		existing.setStatus(order.getStatus());
		existing.setProductId(order.getProductId());
		existing.setOrderQuantity(order.getOrderQuantity());
		return repository.save(existing);
	}

	// Call RestTemplate getorderwithproduct - orderid
	public OrderProductDto getOrderWithProductUsingRestTemplate(Long orderid) throws ResourceNotFoundException {

		Order order = getOrderById(orderid);

		String baseUrl = "http://localhost:8081/products";
		Long productId = order.getProductId();

		Product product = new Product();
//		restTemplate.getForObject(baseUrl + "/" + productId, Product.class);

		OrderProductDto orderProductDto = new OrderProductDto(); // orderwithproduct
		orderProductDto.setOrder(order);
		orderProductDto.setProduct(product);

		return orderProductDto;

	}

	// Call RestClient getorderwithproduct - orderid
	public OrderProductDto getOrderWithProductUsingRestClient(Long orderId) throws ResourceNotFoundException {

		Order order = getOrderById(orderId);
		//String baseUrl = "http://localhost:8081/products";

		// Below one with eureka server
		String baseUrl = "http://PRODUCT-SERVICE/products";

		Long productId = order.getProductId();

		Product product = restClient.get().uri(baseUrl+ "/"+order.getProductId()).retrieve().body(Product.class);

		OrderProductDto orderProductDto = new OrderProductDto(); // orderwithproduct
		orderProductDto.setOrder(order);
		orderProductDto.setProduct(product);

		return orderProductDto;

	}
}
