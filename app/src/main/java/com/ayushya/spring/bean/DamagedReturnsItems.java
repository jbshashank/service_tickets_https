package com.ayushya.spring.bean;

import java.util.Date;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSFile;

public class DamagedReturnsItems {
	
	public String partname;
	public String desc;
	
	public String brand;
	public String category;
	public String subCategory;
	public String model;
	
	public String status;
	public int quantity;
	public GridFSFile gridDBFile;

	
	public DamagedReturnsItems() {	
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}




	public GridFSFile getGridDBFile() {
		return gridDBFile;
	}


	public void setGridDBFile(GridFSFile gridDBFile) {
		this.gridDBFile = gridDBFile;
	}


	public DamagedReturnsItems(String partname, String desc, String brand, String category, String subCategory,
			String model, String status, int quantity, GridFSFile gridFSFile) {
		super();
		this.partname = partname;
		this.desc = desc;
		this.brand = brand;
		this.category = category;
		this.subCategory = subCategory;
		this.model = model;
		this.status = status;
		this.quantity = quantity;
		this.gridDBFile = gridDBFile;
	}

	
}
