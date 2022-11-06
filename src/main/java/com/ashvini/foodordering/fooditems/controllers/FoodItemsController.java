package com.ashvini.foodordering.fooditems.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashvini.foodordering.fooditems.model.FoodItem;
import com.ashvini.foodordering.fooditems.model.FoodItemPojo;
import com.ashvini.foodordering.fooditems.model.Vendor;
import com.ashvini.foodordering.fooditems.model.VendorPojo;
import com.ashvini.foodordering.fooditems.repository.FoodItemRepo;
import com.ashvini.foodordering.fooditems.repository.VendorRepo;

import io.swagger.annotations.ApiOperation;

/**
 * Food items controller class.
 * Exposes REST operations to retrieve Food Items list based on name, vendor and minimum price
 * @author ashvini kumar
 *
 */

@RestController
@RequestMapping("/fooditem")
public class FoodItemsController {
	
	private static Logger logger = LoggerFactory.getLogger(FoodItemsController.class);
	
	@Autowired
	FoodItemRepo foodItemRepo;
	
	@Autowired
	VendorRepo vendorRepo;

	/**
	 * Retrieves All the foodItems in database
	 * @return FoodItemPojo list
	 */
	@GetMapping("/")
	@ApiOperation(value="Get All Food Items",
	notes="See full Food items Catalog available in the restaurant",
	response=FoodItemPojo.class)
	public FoodItemPojo[] getAllFoodItems()
	{
		logger.debug("Request Received for getting All Food Items!");
		FoodItem[] items = foodItemRepo.findAllFoodItems();
		if(items!=null)
			return prepareResponse(items);
		else {
			logger.info("No Food items found in inventory!!");
			return null;
		}
			
	}
	
	/**
	 * Retrieves Food Items containing specified string in the name
	 * @return FoodItemPojo list
	 */
	@GetMapping("/name/{name}")
	@ApiOperation(value="Get Food Items by Item Name",
	notes="Provide Food Item Name to filter the Food Items list",
	response=FoodItemPojo.class)
	public FoodItemPojo[] getFoodItemByName(@PathVariable("name") String name) {
		logger.debug("Request received for lisitng FoodItems Names containing string '"+name+"'");
		FoodItem[] items = foodItemRepo.findByFoodItemName(name);
		if(items!=null)
			return prepareResponse(items);
		else {
			logger.info("No Food items found in inventory!!");
			return new FoodItemPojo[0];
		}
	}
		
	/**
	 * Retrieves the foodItems provided by specified vendor
	 * @return FoodItemPojo list
	 */
	@GetMapping("/vendor/{vendor}")
	@ApiOperation(value="Get Food Items by Vendor Name",
	notes="Provide Vendor Name to filter the Food Items list",
	response=FoodItem.class)
	public FoodItemPojo[] getFoodItemByVendor(@PathVariable("vendor") String name) {
		
		logger.debug("Request received for lisitng FoodItems provided by Vendor '"+name+"'");
		Vendor vendor = vendorRepo.findByVendorName(name);
		if(vendor==null)
			return null;
		FoodItem[] items = foodItemRepo.findByFoodItemVendor(vendor.getVendorId());
		if(items!=null)
			return prepareResponse(items);
		else{
			logger.info("No Food items found in inventory!!");
			return new FoodItemPojo[0];
		}
	}
	
	/**
	 * Retrieves foodItems in database having price >= specified price
	 * @return FoodItemPojo list
	 */
	@GetMapping("/price/{price}")
	@ApiOperation(value="Get Food Items by Item Price",
	notes="Filter fooditems by minimum Price",
	response=FoodItem.class)
	public FoodItemPojo[] getFoodItemByMinPrice(@PathVariable("price") String minPrice) {
		
		logger.debug("Request received for lisitng FoodItems with Price >= "+minPrice);
		float price = 0.0f;
		try {
			price=Float.parseFloat(minPrice);
		} catch(Exception e) {
			return null;
		}
		
		FoodItem[] items = foodItemRepo.findByFoodItemPrice(price);
		if(items!=null)
			return prepareResponse(items);
		else {
			logger.info("No Food items found in inventory!!");
			return new FoodItemPojo[0];
		}
	}

	/**
	 * Convert the FoodItems list into FoodItemPojo list.
	 * Also retrieves the vendor information and fills in FoodItemPojo object
	 * @param foodItems list
	 * @return FoodItemPojo list
	 */
	private FoodItemPojo[] prepareResponse(FoodItem[] foodItems) {
		
		FoodItemPojo[] result = null;
		int l = foodItems.length;
		logger.debug("FoodItems found: "+l);
		result = new FoodItemPojo[l];
		for( int i=0; i<l;i++) {
			FoodItem item = foodItems[i];
			FoodItemPojo foodItemPojo = null;
			Vendor vendor = vendorRepo.findById(item.getFoodItemVendor()).get();
			VendorPojo vp = new VendorPojo(vendor);
			foodItemPojo = new FoodItemPojo(item);
			foodItemPojo.setFoodItemVendor(vp);
			result[i]=foodItemPojo;
			//System.out.println("Added: "+foodItemPojo.getFoodItemNo());
		}
		return result;
	}
}
