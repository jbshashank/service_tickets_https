package com.ayushya.spring.controller;

import javax.validation.Valid;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String createPurchasedItems(@Valid @RequestBody JSONArray array) {
		for(int i=0;i<array.length();i++) {
			purchasedItems items = (purchasedItems) array.get(i);
			repository.save(items);
		}
		return "SUCCESS";
	}
}
