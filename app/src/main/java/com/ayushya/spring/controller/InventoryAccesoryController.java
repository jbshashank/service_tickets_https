package com.ayushya.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ayushya.spring.bean.InventoryAccessories;
import com.ayushya.spring.bean.InventoryParts;
import com.ayushya.spring.repository.InventoryAccessoryRepository;
import com.ayushya.spring.repository.InventoryPartsRepository;
import com.ayushya.spring.service.InventoryService;
import com.ayushya.spring.service.NextSequenceService;

@RestController
@RequestMapping("/inventory/accessories")
public class InventoryAccesoryController {
	
	
	@Autowired
	private InventoryService inventoryService;
	
	@Autowired
	private InventoryAccessoryRepository repository;
	
	
	@Autowired
	private NextSequenceService nextSequenceService;
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public InventoryAccessories createNewItem(@Valid @RequestBody InventoryAccessories itemDetails) {
		itemDetails.set_id(nextSequenceService.getNextSequence("customSequences_accessory"));
		itemDetails.setStatus("Available");
		return repository.save(itemDetails);
	}

	
	@RequestMapping(value = "/request", method = RequestMethod.POST)
	public InventoryAccessories requestNewAccessory(@RequestParam("type") String requestType,@Valid @RequestBody InventoryAccessories itemDetails) {
		itemDetails.set_id(nextSequenceService.getNextSequence("customSequences_accessory"));
		itemDetails.setStatus("Available");
		if(requestType!=null && requestType.contentEquals("true"))	itemDetails.setStatus("Requested");
		return inventoryService.requestNewAccessory(itemDetails);
	}
	
	@RequestMapping(value = "/{brand}/{category}/{sub_category}/{model}", method = RequestMethod.GET)
	public Iterable<InventoryAccessories> fetchAccesory(@PathVariable String brand,@PathVariable String category,@PathVariable String sub_category,@PathVariable String model) {
		return inventoryService.fetchMatchingAccessory(brand,category,sub_category,model);
	}
	
	@RequestMapping(value = "/{brand}/{category}/{model}", method = RequestMethod.GET)
	public Iterable<InventoryAccessories> fetchAccesoryWithoutSubCategory(@PathVariable String brand,@PathVariable String category,@PathVariable String model) {
		return inventoryService.fetchMatchingAccessoryWithoutSubCategory(brand,category,model);
	}
	
	@RequestMapping(value = "/{accessoryId}", method = RequestMethod.PUT)
	public InventoryAccessories updateExisitingAccessory(@PathVariable String accessoryId, @Valid @RequestBody InventoryAccessories itemDetails) {
		return inventoryService.updateAccessory(accessoryId, itemDetails);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<InventoryAccessories> getAllAccessories(){
		return repository.findAll();
	}

}
