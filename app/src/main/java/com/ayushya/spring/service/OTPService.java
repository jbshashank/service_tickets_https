package com.ayushya.spring.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ayushya.spring.bean.InventoryAccessories;
import com.ayushya.spring.bean.InventoryParts;
import com.ayushya.spring.bean.Technician;
import com.ayushya.spring.bean.Tickets;


public interface OTPService {

	public String addOtp (String complaint_id,String event);
	public String validateOTP (String complaint_id,String OTP, String event);

	
}
