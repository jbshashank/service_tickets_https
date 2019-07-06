package com.ayushya.spring.bean;

import java.util.Date;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

public class InventoryAccessories {
	
	@Id
	public String _id;
	public String partname;
	public String desc;
	
	public String brand;
	public String category;
	public String subCategory;
	public String model;
	
	public String status;
	
	public long price;
	public String vendor;
	public int remainingQuantity;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") 
	public Date procurementDate;
	
	public InventoryAccessories() {
			
	}
	
	public InventoryAccessories(String _id, String partname, String desc, String brand, String category, String subCategory,
			String model, String status,long price, String vendor, int remainingQuantity, Date procurementDate) {
		super();
		this._id = _id;
		this.partname = partname;
		this.desc = desc;
		this.brand = brand;
		this.category = category;
		this.subCategory = subCategory;
		this.model = model;
		this.status = status;
		this.price = price;
		this.vendor = vendor;
		this.remainingQuantity = remainingQuantity;
		this.procurementDate = procurementDate;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getPartname() {
		return partname;
	}

	public void setPartname(String partname) {
		this.partname = partname;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public int getRemainingQuantity() {
		return remainingQuantity;
	}

	public void setRemainingQuantity(int remainingQuantity) {
		this.remainingQuantity = remainingQuantity;
	}

	public Date getProcurementDate() {
		return procurementDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setProcurementDate(Date procurementDate) {
		this.procurementDate = procurementDate;
	}


	
}
