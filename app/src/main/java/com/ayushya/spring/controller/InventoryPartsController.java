package com.ayushya.spring.controller;

import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("/inventory/parts")
public class InventoryPartsController {
	
	
	@Autowired
	private InventoryService inventoryPartService;
	
	@Autowired
	private InventoryPartsRepository repository;
	
	
	@Autowired
	private NextSequenceService nextSequenceService;
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public InventoryParts createNewItem(@Valid @RequestBody InventoryParts inventoryParts) {
		inventoryParts.set_id(nextSequenceService.getNextSequence("customSequences_parts"));
		inventoryParts.setStatus("Available");
		return repository.save(inventoryParts);
	}
	
	@RequestMapping(value = "/request", method = RequestMethod.POST)
	public InventoryParts requestNewItem(@Valid @RequestBody InventoryParts inventoryParts,@RequestParam("type") String requestType,HttpServletRequest httpServletRequest) {
		InventoryParts inventoryParts1 = null;
		System.out.println(" REQUEST TYPE IS HERERERERERERERE "+requestType+":"+httpServletRequest.getParameter("x-ticketnumber")+":"+httpServletRequest.getParameter("x-accountid")+":::"+httpServletRequest.getParameter("x-userid"));
		inventoryParts.set_id(nextSequenceService.getNextSequence("customSequences_parts"));
		inventoryParts.setStatus("Requested");
		inventoryParts1 = inventoryPartService.requestNewPart(inventoryParts);
		System.out.println(" REQUEST TYPE IS <<PARTS>> "+inventoryParts1.getBrand());
		return inventoryPartService.requestNewPart(inventoryParts);
	}
	
	
	@RequestMapping(value = "/{brand}/{category}/{sub_category}/{model}", method = RequestMethod.GET)
	public Iterable<InventoryParts> fetchParts(@PathVariable String brand,@PathVariable String category,@PathVariable String sub_category,@PathVariable String model) {
		System.out.println(" THE VALUES ARE :"+brand+":"+category+"::"+sub_category+":::"+model);
		return inventoryPartService.fetchMatchingParts(brand,category,sub_category,model);
	}
	
	@RequestMapping(value = "/{brand}/{category}/{model}", method = RequestMethod.GET)
	public Iterable<InventoryParts> fetchPartsWithoutSubCategory(@PathVariable String brand,@PathVariable String category,@PathVariable String model) {
		System.out.println(" THE VALUES ARE << WITH SUB >>:"+brand+":"+category+"::"+":::"+model);
		return inventoryPartService.fetchMatchingPartsWithoutSubCategory(brand, category, model);
	}
	
	@RequestMapping(value = "/{partId}", method = RequestMethod.PUT)
	public InventoryParts updateExisitingPart(@PathVariable String partId, @Valid @RequestBody InventoryParts itemDetails) {
		return inventoryPartService.updatePart(partId, itemDetails);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Iterable<InventoryParts> getAllItems(){
		return repository.findAll();
	}

}
