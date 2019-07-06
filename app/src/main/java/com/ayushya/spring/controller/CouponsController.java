package com.ayushya.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Nagendra Kumar
 *
 */
@RestController
@RequestMapping("/coupons")
public class CouponsController {
	
	/**
	 * default constructor
	 */
	public CouponsController() {
		
	}
	
	/**
	 * get coupon amount
	 */
	@RequestMapping("/")
	public String getCouponValue(@RequestParam("id") String id) {
		
		if(id==null) {
			return "#Invalid Coupoun";
		}else if(id.equalsIgnoreCase("ayushya50")) {
			return "50";
		}
		else if(id.equalsIgnoreCase("ayushya100")) {
			return "100";
		}
		else if(id.equalsIgnoreCase("ayushya150")) {
			return "150";
		}
		else if(id.equalsIgnoreCase("ayushya200")) {
			return "200";
		}
		else {
			return "#Invalid Coupoun";
		}
		}
	

}
