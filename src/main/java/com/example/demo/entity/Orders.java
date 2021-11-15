package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Orders")
public class Orders {
	
	@Id
//	@GeneratedValue
	private int order_id;
	private String order_datetime;
	private String orderer_name;
	private int device_id;
	private String device_name;
	
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getOrder_datetime() {
		return order_datetime;
	}
	public void setOrder_datetime(String order_datetime) {
		this.order_datetime = order_datetime;
	}
	public String getOrderer_name() {
		return orderer_name;
	}
	public void setOrderer_name(String orderer_name) {
		this.orderer_name = orderer_name;
	}
	public int getDevice_id() {
		return device_id;
	}
	public void setDevice_id(int device_id) {
		this.device_id = device_id;
	}
	public String getDevice_name() {
		return device_name;
	}
	public void setDevice_name(String device_name) {
		this.device_name = device_name;
	}
	
	@Override
	public String toString() {
		return "Orders [order_id=" + order_id + ", order_datetime=" + order_datetime + ", orderer_name=" + orderer_name
				+ ", device_id=" + device_id + ", device_name=" + device_name + "]";
	}	
	
}
