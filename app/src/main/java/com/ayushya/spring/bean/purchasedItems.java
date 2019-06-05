package com.ayushya.spring.bean;

import org.springframework.data.annotation.Id;

public class purchasedItems {
	
	@Id
	public String _id;
	public String name;
	public String partID;
	public String desc;
	public String price;
	public String category;
	public String subCategory;
	
	public purchasedItems() {
		
	}

	public purchasedItems(String _id, String name, String partID, String desc, String price, String category,
			String subCategory) {
		super();
		this._id = _id;
		this.name = name;
		this.partID = partID;
		this.desc = desc;
		this.price = price;
		this.category = category;
		this.subCategory = subCategory;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPartID() {
		return partID;
	}

	public void setPartID(String partID) {
		this.partID = partID;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
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
	

}
