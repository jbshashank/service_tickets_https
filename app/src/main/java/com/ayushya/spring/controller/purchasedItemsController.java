package com.ayushya.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ayushya.spring.bean.purchasedItems;
import com.ayushya.spring.repository.purchasedItemsRepository;

@RestController
@RequestMapping("/purchasedItems")
public class purchasedItemsController {
	@Autowired
	private purchasedItemsRepository repository;
	
	@RequestMapping(value = "/{_id}", method = RequestMethod.POST)
	public String createPurchasedItems(@PathVariable String _id,@Valid @RequestBody purchasedItems items) {
		items.set_id(_id);
		repository.save(items);
		return "{\"Updation\":\"SUCCESS\"}";
	}
}
