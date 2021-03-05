package com.catalouge.model;

public class Discount {


	private double discountPrice;
	private long discountCount;


	public Discount(long discountPrice, long discountCount) {
		this.discountCount = discountCount;
		this.discountPrice = discountPrice;
	}


	public double getDiscountPrice() {
		return discountPrice;
	}


	public long getDiscountCount() {
		return discountCount;
	}



}
