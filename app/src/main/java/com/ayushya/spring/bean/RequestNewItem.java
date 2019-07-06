package com.ayushya.spring.bean;

import org.springframework.data.annotation.Id;

public class RequestNewItem {
	
	@Id
	public String _id;
	public String partname;
	public String part_id;
	public String model_id;
	public String vendor;
	
	public RequestNewItem() {
		
	}

	public RequestNewItem(String _id, String partname, String part_id, String model_id, String vendor) {
		super();
		this._id = _id;
		this.partname = partname;
		this.part_id = part_id;
		this.model_id = model_id;
		this.vendor = vendor;
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

	public String getPart_id() {
		return part_id;
	}

	public void setPart_id(String part_id) {
		this.part_id = part_id;
	}

	public String getModel_id() {
		return model_id;
	}

	public void setModel_id(String model_id) {
		this.model_id = model_id;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	
	
}
