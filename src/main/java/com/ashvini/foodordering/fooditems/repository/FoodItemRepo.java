package com.ashvini.foodordering.fooditems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ashvini.foodordering.fooditems.model.FoodItem;

public interface FoodItemRepo extends JpaRepository<FoodItem, Integer> {
	
	@Query("SELECT fi FROM FoodItem fi WHERE LOWER(fi.foodItemName) like CONCAT('%',LOWER(?1),'%')")
	FoodItem[] findByFoodItemName(String foodItemName);
	
	@Query("SELECT fi FROM FoodItem fi WHERE fi.foodItemPrice >= ?1")
	FoodItem[] findByFoodItemPrice(float foodItemPrice);
	
	@Query("SELECT fi FROM FoodItem fi")
	FoodItem[] findAllFoodItems();
	
	@Query("SELECT fi FROM FoodItem fi WHERE fi.foodItemVendor = ?1")
	FoodItem[] findByFoodItemVendor(int foodItemVendor);

}
