package com.ayushya.spring.bean;

import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;

public class OTP {
	@Id
	public String _id;
	public Map<String,OTPDetails> oTPDetails;
	
	public OTP()
	{
		
	}
	
	public OTP(String _id, Map<String,OTPDetails> oTPDetails) {
		super();
		this._id = _id;
		this.oTPDetails = oTPDetails;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public Map<String,OTPDetails> getoTPDetails() {
		return oTPDetails;
	}

	public void setoTPDetails(Map<String,OTPDetails> oTPDetails) {
		this.oTPDetails = oTPDetails;
	}
	
}
