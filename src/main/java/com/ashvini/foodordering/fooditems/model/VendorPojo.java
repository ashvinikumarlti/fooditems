package com.ashvini.foodordering.fooditems.model;

public class VendorPojo {
	
	private int vendorId;
	
	private String vendorName;
	
	public VendorPojo(Vendor vendor) {
		super();
		this.vendorId = vendor.getVendorId();
		this.vendorName = vendor.getVendorName();
	}

	public VendorPojo(int vendorId, String vendorName) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}


}
