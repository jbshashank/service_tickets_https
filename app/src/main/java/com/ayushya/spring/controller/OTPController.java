package com.ayushya.spring.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ayushya.spring.bean.DamagedReturns;
import com.ayushya.spring.bean.TechFeedback;
import com.ayushya.spring.repository.DamagedReturnsRepository;
import com.ayushya.spring.repository.TechnicianFeedbackRepository;
import com.ayushya.spring.service.DamagedReturnService;
import com.ayushya.spring.service.OTPService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/OTP")
public class OTPController {
	
	
	@Autowired
	private OTPService oTPService;
	
	
	@GetMapping(value = "/{ticket_number}/{OTP}/{EVENT}")
	public String getDamagedReturnsList(@PathVariable String ticket_number,@PathVariable String OTP,@PathVariable String EVENT) {
		System.out.println(" THE OTP IS <<OTP>> : "+OTP+":"+ticket_number+"::::"+EVENT);
		String str = oTPService.validateOTP(ticket_number, OTP, EVENT);
		System.out.println(" THE OTP IS <<STATUS : >> : "+str);
		return str;
	}
	
}


