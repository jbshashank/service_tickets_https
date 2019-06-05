package com.ayushya.spring.bean;

import org.springframework.data.annotation.Id;

public class technician {

	@Id
	public String _id;
	public String mobile_number;
	public String address;
	public String city;
	public String pin_code;
	public String expert_in;
	public String level_of_expertise;
	public int no_assigned;
	
	public technician() {
		
	}

	public technician(String _id, String mobile_number, String address, String city, String pin_code, String expert_in,
			String level_of_expertise, int no_assigned) {
		super();
		this._id = _id;
		this.mobile_number = mobile_number;
		this.address = address;
		this.city = city;
		this.pin_code = pin_code;
		this.expert_in = expert_in;
		this.level_of_expertise = level_of_expertise;
		this.no_assigned = no_assigned;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPin_code() {
		return pin_code;
	}

	public void setPin_code(String pin_code) {
		this.pin_code = pin_code;
	}

	public String getExpert_in() {
		return expert_in;
	}

	public void setExpert_in(String expert_in) {
		this.expert_in = expert_in;
	}

	public String getLevel_of_expertise() {
		return level_of_expertise;
	}

	public void setLevel_of_expertise(String level_of_expertise) {
		this.level_of_expertise = level_of_expertise;
	}

	public int getNo_assigned() {
		return no_assigned;
	}

	public void setNo_assigned(int no_assigned) {
		this.no_assigned = no_assigned;
	}

}
