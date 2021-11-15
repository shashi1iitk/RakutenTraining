package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Orders;
import com.example.demo.service.OrdersService;

@RestController
public class OrdersController {
	
	@Autowired
	private OrdersService service;
	
	//Save order
	@PostMapping("/orders")
	public Orders addOrder(@RequestBody Orders order) {
		return service.saveOrder(order);
	}
	
	//Acquire all order details
	@GetMapping("/orders")
	public List<Orders> getOrders() {
		return service.getOrders();
	}
	
	//Acquire order details by id
	@GetMapping("/orders/{order_id}")
	public Orders getOrder(@PathVariable int order_id) {
		return service.getOrderById(order_id);
	}
	
	//Updating order by id
	@PutMapping("/orders")
	public Orders updateOrder(@RequestBody Orders order) {
		return service.updateOrder(order);
	}
	
	//Deleting order by id
	@DeleteMapping("/orders/{order_id}")
	public String deleteOrder(@PathVariable int order_id) {
		return service.deleteOrder(order_id);
	}
	
}
