package com.example.demo.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Orders;
import com.example.demo.repository.OrdersRepository;

@Service
public class OrdersService {
	@Autowired
	private OrdersRepository repo;
	
	// Save
	public Orders saveOrder(Orders order) {
		order.setOrder_datetime( new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()) );
		return repo.save(order);
	}
	
	//Acquire orders
	public List<Orders> getOrders(){
		return repo.findAll();
	}
	
	//Acquire order
	public Orders getOrderById(int order_id){
		return repo.findById(order_id).orElse(null);
	}
	
	//Delete
	public String deleteOrder(int order_id) {
		repo.deleteById(order_id);
		return "Product deleted- " + order_id;
	}
	
	//Update order
	public Orders updateOrder(Orders order) {
		Orders existingOrder= repo.findById(order.getOrder_id()).orElse(null);
		
		existingOrder.setDevice_id(order.getDevice_id());
		existingOrder.setDevice_name((order.getDevice_name()));
		existingOrder.setOrder_datetime( new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()) );
		existingOrder.setOrderer_name(order.getOrderer_name());
		
		return repo.save(existingOrder);
	}

}
