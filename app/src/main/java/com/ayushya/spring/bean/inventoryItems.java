package com.ayushya.spring.bean;

import org.springframework.data.annotation.Id;

public class inventoryItems {
	
	@Id
	public String _id;
	public String partname;
	public String price;
	public String desc;
	public String model_id;
	public String part_id;
	public String vendor;
	public String remaining_quantity;
	public String procurement_date;
	
	public inventoryItems() {
		
	}

	public inventoryItems(String _id, String partname, String price, String desc, String model_id, String part_id,
			String vendor, String remaining_quantity, String procurement_date) {
		super();
		this._id = _id;
		this.partname = partname;
		this.price = price;
		this.desc = desc;
		this.model_id = model_id;
		this.part_id = part_id;
		this.vendor = vendor;
		this.remaining_quantity = remaining_quantity;
		this.procurement_date = procurement_date;
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getModel_id() {
		return model_id;
	}

	public void setModel_id(String model_id) {
		this.model_id = model_id;
	}

	public String getPart_id() {
		return part_id;
	}

	public void setPart_id(String part_id) {
		this.part_id = part_id;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getRemaining_quantity() {
		return remaining_quantity;
	}

	public void setRemaining_quantity(String remaining_quantity) {
		this.remaining_quantity = remaining_quantity;
	}

	public String getProcurement_date() {
		return procurement_date;
	}

	public void setProcurement_date(String procurement_date) {
		this.procurement_date = procurement_date;
	}
	
	
}
