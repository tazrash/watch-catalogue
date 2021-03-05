package com.catalouge.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="watchCatalouge")
public class WatchCatalouge {


	@Id
	private String watchId;

	private String watchName;
	private boolean isDiscountEligible;
	private double singleUnitPrice;

	private double discountPrice;
	private long discountCount;



	public WatchCatalouge(String watchId, String watchName, boolean isDiscountEligible, double singleUnitPrice, double discountPrice, long discountCount) {
		this.watchId = watchId;
		this.watchName = watchName;
		this.isDiscountEligible =  isDiscountEligible;
		this.singleUnitPrice = singleUnitPrice;
		this.discountPrice = discountPrice;
		this.discountCount = discountCount;
	}



	public double getDiscountPrice() {
		return discountPrice;
	}



	public long getDiscountCount() {
		return discountCount;
	}



	public String getWatchId() {
		return watchId;
	}

	public String getWatchName() {
		return watchName;
	}

	public boolean isDiscountEligible() {
		return isDiscountEligible;
	}


	public double getSingleUnitPrice() {
		return singleUnitPrice;
	}


	public WatchCatalouge() {
		
	}



}


