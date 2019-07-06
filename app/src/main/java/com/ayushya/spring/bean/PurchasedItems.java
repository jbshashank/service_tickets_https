package com.ayushya.spring.bean;

import org.springframework.data.annotation.Id;

import com.mongodb.BasicDBList;

public class PurchasedItems {
	
	@Id
	public String _id;
	public BasicDBList Inventory_Parts;
	
	public PurchasedItems() {
		
	}

	public PurchasedItems(String _id, BasicDBList inventory_Parts) {
		super();
		this._id = _id;
		this.Inventory_Parts = inventory_Parts;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public BasicDBList getInventory_Parts() {
		return Inventory_Parts;
	}

	public void setInventory_Parts(BasicDBList inventory_Parts) {
		Inventory_Parts = inventory_Parts;
	}
	
	
	
}
