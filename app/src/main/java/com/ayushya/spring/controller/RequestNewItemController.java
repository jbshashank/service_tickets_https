package com.ayushya.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ayushya.spring.bean.RequestNewItem;
import com.ayushya.spring.repository.RequestNewItemRepository;

@RestController
@RequestMapping("/reqnew")
public class RequestNewItemController {
	
	@Autowired
	private RequestNewItemRepository repository;
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public RequestNewItem RequestNewItem(@Valid @RequestBody RequestNewItem newItemDetails) {
		return repository.save(newItemDetails);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Iterable<RequestNewItem> getAllRequestedItems(){
		return repository.findAll();
	}
	
}
