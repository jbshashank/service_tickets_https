package com.ayushya.spring.controller;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayushya.spring.service.EmailService;

@RestController
@RequestMapping("/email")
public class emailController {

	@PostMapping(value = "/")
	public String createAndSendEmail(@RequestBody JSONObject mailsObject) throws AddressException, MessagingException {
		if(new EmailService().sendEmailUsingSMTP(mailsObject)) {
			return "SUCCESS";
		}
		return "FAILED";
	}
	
}
