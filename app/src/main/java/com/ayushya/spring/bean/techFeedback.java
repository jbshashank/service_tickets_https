package com.ayushya.spring.bean;

import org.springframework.data.annotation.Id;

public class techFeedback {
	
	@Id
	public String _id;
	public String rating;
	public String comment;
	public String trans_id;
	public String pay_type;
	
	public techFeedback() {
		
	}
	
	public techFeedback(String _id, String rating, String comment, String trans_id, String pay_type) {
		super();
		this._id = _id;
		this.rating = rating;
		this.comment = comment;
		this.trans_id = trans_id;
		this.pay_type = pay_type;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getTrans_id() {
		return trans_id;
	}

	public void setTrans_id(String trans_id) {
		this.trans_id = trans_id;
	}

	public String getPay_type() {
		return pay_type;
	}

	public void setPay_type(String pay_type) {
		this.pay_type = pay_type;
	}
	
}
