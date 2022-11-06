package com.ashvini.foodordering.fooditems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashvini.foodordering.fooditems.model.Vendor;

public interface VendorRepo extends JpaRepository<Vendor, Integer>{
	
	Vendor findByVendorName(String vendorName);

}
