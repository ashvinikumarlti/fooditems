package com.ashvini.foodordering.fooditems.model;

public class FoodItemPojo {
	
private int foodItemNo;
	
	private String foodItemName;
	
    private VendorPojo foodItemVendor;
	
	private float foodItemPrice;
	
	public FoodItemPojo(FoodItem item) {
		super();
		this.foodItemNo = item.getFoodItemNo();
		this.foodItemName = item.getFoodItemName();
		//this.foodItemVendor = item.getFoodItemVendor()
		this.foodItemPrice = item.getFoodItemPrice();
	}

	public FoodItemPojo(int foodItemNo, String foodItemName, VendorPojo foodItemVendor, float foodItemPrice) {
		super();
		this.foodItemNo = foodItemNo;
		this.foodItemName = foodItemName;
		this.foodItemVendor = foodItemVendor;
		this.foodItemPrice = foodItemPrice;
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

	public VendorPojo getFoodItemVendor() {
		return foodItemVendor;
	}

	public void setFoodItemVendor(VendorPojo foodItemVendor) {
		this.foodItemVendor = foodItemVendor;
	}

	public float getFoodItemPrice() {
		return foodItemPrice;
	}

	public void setFoodItemPrice(float foodItemPrice) {
		this.foodItemPrice = foodItemPrice;
	}

	
}
