package com.ayushya.spring.service;

import java.util.Base64;

import org.json.simple.JSONObject;

import com.ayushya.spring.helper.GlobalConstants;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SMSService {
	
	public boolean sendSMS(JSONObject smsObject) {
		byte[] decoded_ACCOUNT_SID = Base64.getDecoder().decode(GlobalConstants.ACCOUNT_SID);
		byte[] decoded_AUTH_TOKEN = Base64.getDecoder().decode(GlobalConstants.AUTH_TOKEN);
		Twilio.init(new String(decoded_ACCOUNT_SID), new String(decoded_AUTH_TOKEN));
		Message message = Message.creator(
				new PhoneNumber("+91"+smsObject.get("to").toString()),
				new PhoneNumber("+16264005615"),
				smsObject.get("body").toString()).create();
		if(!message.getSid().isEmpty()) {
			return true;
		}
		return false;
	}
}
