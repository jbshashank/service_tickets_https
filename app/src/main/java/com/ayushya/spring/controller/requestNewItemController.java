package com.ayushya.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ayushya.spring.bean.requestNewItem;
import com.ayushya.spring.repository.requestNewItemRepository;

@RestController
@RequestMapping("/reqnew")
public class requestNewItemController {
	
	@Autowired
	private requestNewItemRepository repository;
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public requestNewItem RequestNewItem(@Valid @RequestBody requestNewItem newItemDetails) {
		return repository.save(newItemDetails);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Iterable<requestNewItem> getAllRequestedItems(){
		return repository.findAll();
	}
	
}
