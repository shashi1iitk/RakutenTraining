package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer>{

}
