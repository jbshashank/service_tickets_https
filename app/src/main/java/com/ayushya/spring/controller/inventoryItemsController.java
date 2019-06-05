package com.ayushya.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ayushya.spring.bean.inventoryItems;
import com.ayushya.spring.repository.inventoryItemsRepository;

@RestController
@RequestMapping("/inventory")
public class inventoryItemsController {
	
	@Autowired
	private inventoryItemsRepository repository;
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public inventoryItems createNewItem(@Valid @RequestBody inventoryItems itemDetails) {
		itemDetails.set_id(itemDetails.getModel_id() + itemDetails.getPart_id());
		return repository.save(itemDetails);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Iterable<inventoryItems> getAllItems(){
		return repository.findAll();
	}

}
