package com.ayushya.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayushya.spring.bean.Cart;
import com.ayushya.spring.repository.CartRepository;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartRepository repository;
	
	@PostMapping(value = "/")
	public Cart addPartsToCart(@Valid @RequestBody Cart cart) {
		cart.set_id(cart.getComplaintNo());
		repository.save(cart);
		return cart;
	}
	
	@GetMapping(value = "/{complaintNo}")
	public Cart getPartsInCart(@PathVariable String complaintNo) {
		return repository.findOne(complaintNo);
	}
	
}
