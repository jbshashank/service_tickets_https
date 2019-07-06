package com.ayushya.spring.bean;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class OTPDetails {
	public String OTP;
	public String OTPEventType;
	public Date OTPExpiry;
	public String getOTP() {
		return OTP;
	}
	public void setOTP(String oTP) {
		System.out.println(" OTP GENERATED IS "+oTP);
		OTP = oTP;
	}
	public String getOTPEventType() {
		
		return OTPEventType;
	}
	public void setOTPEventType(String oTPEventType) {
		System.out.println(" OTP EVENT  IS "+oTPEventType);
		OTPEventType = oTPEventType;
	}
	public Date getOTPExpiry() {
		return OTPExpiry;
	}
	public void setOTPExpiry(Date oTPExpiry) {
		OTPExpiry = oTPExpiry;
	}
	public OTPDetails(String oTP, String oTPEventType, Date oTPExpiry) {
		super();
		OTP = oTP;
		OTPEventType = oTPEventType;
		OTPExpiry = oTPExpiry;
	}
	public OTPDetails()
	{
		
	}
}
