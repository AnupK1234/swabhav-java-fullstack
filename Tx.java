package com.aurionpro.model;

class Tx {
	private int year;
	private String trader;
	private int value;

	public Tx(int year, String trader, int value) {
		super();
		this.year = year;
		this.trader = trader;
		this.value = value;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getTrader() {
		return trader;
	}

	public void setTrader(String trader) {
		this.trader = trader;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}