package com.ashvini.foodordering.fooditems.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class FoodItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int foodItemNo;
	
	private String foodItemName;
	
    private int foodItemVendor;
	
	private float foodItemPrice;
	
	public FoodItem() {}

	public FoodItem(int foodItemNo, String foodItemName, int foodItemVendor, float footItemPrice) {
		super();
		this.foodItemNo = foodItemNo;
		this.foodItemName = foodItemName;
		this.foodItemVendor = foodItemVendor;
		this.foodItemPrice = footItemPrice;
	}

	public int getFoodItemNo() {
		return foodItemNo;
	}

	public void setFoodItemNo(int foodItemNo) {
		this.foodItemNo = foodItemNo;
	}

	public String getFoodItemName() {
		return foodItemName;
	}

	public void setFoodItemName(String foodItemName) {
		this.foodItemName = foodItemName;
	}

	public int getFoodItemVendor() {
		return foodItemVendor;
	}

	public void setFoodItemVendor(int foodItemVendor) {
		this.foodItemVendor = foodItemVendor;
	}

	public float getFoodItemPrice() {
		return foodItemPrice;
	}

	public void setFootItemPrice(float foodItemPrice) {
		this.foodItemPrice = foodItemPrice;
	}
	

}
