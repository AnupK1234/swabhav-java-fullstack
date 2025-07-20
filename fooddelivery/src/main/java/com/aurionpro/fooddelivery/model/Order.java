package com.aurionpro.fooddelivery.model;

import java.time.LocalDateTime;
import java.util.List;

import com.aurionpro.fooddelivery.enums.PaymentMode;

public class Order {
	private int id;
	private List<OrderItem> items;
	private double totalAmount;
	private double discout;
	private double finalAmt;
	private PaymentMode paymentMode;
	private LocalDateTime timestamp;

	public Order(int id, List<OrderItem> items, double totalAmount, double discout, PaymentMode paymentMode) {
		this.id = id;
		this.items = items;
		this.totalAmount = totalAmount;
		this.discout = discout;
//		this.finalAmt = finalAmt;
		this.paymentMode = paymentMode;
		this.timestamp = LocalDateTime.now();
	}

	public int getId() {
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
