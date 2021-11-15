package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Orders;
import com.example.demo.service.OrdersService;


import com.example.demo.repository.OrdersRepository;
import com.example.demo.controller.OrdersController;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestMethodOrder(OrderAnnotation.class)
class RakutenTrainingApplicationTests {
	
	@Autowired
	OrdersService service;
	
	@Autowired
	OrdersController control;
	
	@Autowired
	private OrdersRepository repo;
	
//	@Test
//	void contextLoads() {
//	}
	
	
	//Testing Service class
//	@Test
//	public void testSaveOrder() {
//		
//		Orders o = new Orders();
//		
//		o.setOrder_id(15);
//		o.setDevice_id(5467);
//		o.setDevice_name("Vivo phone");
//		o.setOrder_datetime( new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()) );
//		o.setOrderer_name("Shashi Kumar");
//		
//		service.saveOrder(o);		
//		assertNotNull(repo.findById(15).get());				
//	}
	
	//Testing Order registration Route - Controller class method
	@Test
	@Order(1)
	public void testAddOrder() {
		
		Orders o = new Orders();
		
		o.setOrder_id(1);
		o.setDevice_id(1537);
		o.setDevice_name("Vivo phone");
		o.setOrder_datetime( new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()) );
		o.setOrderer_name("Shashi Kumar");
		
		control.addOrder(o);		
		assertNotNull(repo.findById(1).get());	
	}
	
	//Testing Bulk order acquisition -
	@Test
	@Order(2)
	public void testBulkOrderAcq() {
		List<Orders> order = control.getOrders();
		assertThat(order).size().isGreaterThan(0);
	}
	
	//Testing Single order acquisition -
	@Test
	@Order(3)
	public void testOrderAcq() {
		Orders order = control.getOrder(1);
		System.out.println(order);
		System.out.println(repo.findById(1));
		assertEquals(order, repo.findById(1));
	}
		
	//Testing update route
	@Test
	@Order(4)
	public void testUpdate() {
		Orders order = control.getOrder(1);
		order.setDevice_id(1234);
		control.updateOrder(order);
		assertNotEquals(1000, repo.findById(1).get().getDevice_id());
	}
	
	//Testing delete route
	@Test
	@Order(5)
	public void testDelete() {
		control.deleteOrder(1);
		assertThat(repo.existsById(1)).isFalse();
	}
}
