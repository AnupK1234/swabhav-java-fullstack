package com.aurionpro.fooddelivery.model;

import java.time.LocalDateTime;
import java.util.List;

import com.aurionpro.fooddelivery.enums.PaymentMode;

import struqt.util.UniqueIdGenerator;

public class Order {
	private long id;
	private List<OrderItem> items;
	private double totalAmount;
	private double discout;
	private double finalAmt;
	private PaymentMode paymentMode;
	private LocalDateTime timestamp;
	UniqueIdGenerator generator = new UniqueIdGenerator(1L);

	public Order(List<OrderItem> items, double totalAmount, double discout, PaymentMode paymentMode) {
		this.id = generator.next();
		this.items = items;
		this.totalAmount = totalAmount;
		this.discout = discout;
//		this.finalAmt = finalAmt;
		this.paymentMode = paymentMode;
		this.timestamp = LocalDateTime.now();
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getDiscout() {
		return discout;
	}

	public void setDiscout(double discout) {
		this.discout = discout;
	}

	public double getFinalAmt() {
		return finalAmt;
	}

	public void setFinalAmt(double finalAmt) {
		this.finalAmt = finalAmt;
	}

	public PaymentMode getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

}
