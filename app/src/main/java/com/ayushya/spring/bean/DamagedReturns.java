package com.ayushya.spring.bean;

import java.util.List;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class DamagedReturns {
	
	@Id
	public String _id;
	public List<DamagedReturnsItems> damagedReturnsItems;
	
	public DamagedReturns() {	
	}

	public DamagedReturns(String _id, List<DamagedReturnsItems> damagedReturnsItems) {
		super();
		this._id = _id;
		this.damagedReturnsItems = damagedReturnsItems;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public List<DamagedReturnsItems> getDamagedReturnsItems() {
		return damagedReturnsItems;
	}

	public void setDamagedReturnsItems(List<DamagedReturnsItems> damagedReturnsItems) {
		this.damagedReturnsItems = damagedReturnsItems;
	}

	
	
}
