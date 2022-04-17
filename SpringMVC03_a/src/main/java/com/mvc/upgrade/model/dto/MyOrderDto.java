package com.mvc.upgrade.model.dto;

import java.util.Date;

public class MyOrderDto {
	
	
	private int orderSeq;
	private int productPrice;
	private int delivery;
	private int amount;
	private String receiveAddress;
	private String receiveName;
	private int quantity;
	private String productName;
	private Date orderDate;
	private int productSeq;
	private String userId;
	public MyOrderDto() {
		
	}
	public MyOrderDto(int orderSeq, int productPrice, int delivery, int amount, String receiveAddress,
			String receiveName, int quantity, String productName, Date orderDate, int productSeq, String userId) {
		
		this.orderSeq = orderSeq;
		this.productPrice = productPrice;
		this.delivery = delivery;
		this.amount = amount;
		this.receiveAddress = receiveAddress;
		this.receiveName = receiveName;
		this.quantity = quantity;
		this.productName = productName;
		this.orderDate = orderDate;
		this.productSeq = productSeq;
		this.userId = userId;
	}
	public int getOrderSeq() {
		return orderSeq;
	}
	public void setOrderSeq(int orderSeq) {
		this.orderSeq = orderSeq;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getDelivery() {
		return delivery;
	}
	public void setDelivery(int delivery) {
		this.delivery = delivery;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getReceiveAddress() {
		return receiveAddress;
	}
	public void setReceiveAddress(String receiveAddress) {
		this.receiveAddress = receiveAddress;
	}
	public String getReceiveName() {
		return receiveName;
	}
	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getProductSeq() {
		return productSeq;
	}
	public void setProductSeq(int productSeq) {
		this.productSeq = productSeq;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	

	
}
