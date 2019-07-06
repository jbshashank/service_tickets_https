package com.ayushya.spring.bean;

import org.springframework.data.annotation.Id;

import com.mongodb.BasicDBList;

public class Cart {

	@Id
	public String _id;
	public String complaintNo;
	public String userId;
	public String totalEstimate;
	public BasicDBList items;
	
	public Cart() {
		
	}

	public Cart(String _id, String complaintNo, String userId, String totalEstimate, BasicDBList items) {
		super();
		this._id = _id;
		this.complaintNo = complaintNo;
		this.userId = userId;
		this.totalEstimate = totalEstimate;
		this.items = items;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getComplaintNo() {
		return complaintNo;
	}

	public void setComplaintNo(String complaintNo) {
		this.complaintNo = complaintNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTotalEstimate() {
		return totalEstimate;
	}

	public void setTotalEstimate(String totalEstimate) {
		this.totalEstimate = totalEstimate;
	}

	public BasicDBList getItems() {
		return items;
	}

	public void setItems(BasicDBList items) {
		this.items = items;
	}

	

}
