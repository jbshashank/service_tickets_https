package com.ayushya.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayushya.spring.bean.cart;
import com.ayushya.spring.repository.cartRepository;

@RestController
@RequestMapping("/cart")
public class cartController {
	
	@Autowired
	private cartRepository repository;
	
	@PostMapping(value = "/")
	public cart addPartsToCart(@Valid @RequestBody cart cart) {
		cart.set_id(cart.getComplaintNo());
		repository.save(cart);
		return cart;
	}
	
	@GetMapping(value = "/{complaintNo}")
	public cart getPartsInCart(@PathVariable String complaintNo) {
		return repository.findOne(complaintNo);
	}
	
}
