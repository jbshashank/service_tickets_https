package com.ayushya.spring.controller;

import javax.validation.Valid;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ayushya.spring.service.SMSService;

@RestController
@RequestMapping("/sms")
public class SMSController {

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String createAndSendSMS(@Valid @RequestBody JSONObject SMSDetails) {
		if(new SMSService().sendSMS(SMSDetails)) {
			return "SUCCESS";
		}
		return null;
	}
}
