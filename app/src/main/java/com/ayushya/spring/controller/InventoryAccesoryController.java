package com.ayushya.spring.controller;

import java.util.List;

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
import com.ayushya.spring.bean.Tickets;
import com.ayushya.spring.repository.InventoryAccessoryRepository;
import com.ayushya.spring.repository.InventoryPartsRepository;
import com.ayushya.spring.repository.TicketsRepository;
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
	private TicketsRepository ticketsRepository;
	
	@Autowired
	private NextSequenceService nextSequenceService;
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public InventoryAccessories createNewItem(@Valid @RequestBody InventoryAccessories itemDetails,HttpServletRequest request) {
		itemDetails.set_id(nextSequenceService.getNextSequence("customSequences_accessory"));
		String ticket_id = request.getHeader("x-ticket");
		if(ticket_id!=null) {
			Tickets t = ticketsRepository.findOne(ticket_id);
			itemDetails.setModel(t.getModel_name());
			itemDetails.setBrand(t.getBrand());
			itemDetails.setCategory(t.getProduct_category());
			itemDetails.setSubCategory(t.getProduct_sub_category());
		}
		itemDetails.setStatus("Available");
		return repository.save(itemDetails);
	}

	
	@RequestMapping(value = "/request", method = RequestMethod.POST)
	public InventoryAccessories requestNewAccessory(HttpServletRequest request,@RequestParam("type") String requestType,@Valid @RequestBody InventoryAccessories itemDetails) {
		itemDetails.set_id(nextSequenceService.getNextSequence("customSequences_accessory"));
		String ticket_id = request.getHeader("x-ticket");
		if(ticket_id!=null) {
			Tickets t = ticketsRepository.findOne(ticket_id);
			itemDetails.setModel(t.getModel_name());
			itemDetails.setBrand(t.getBrand());
			itemDetails.setCategory(t.getProduct_category());
			itemDetails.setSubCategory(t.getProduct_sub_category());
		}		itemDetails.setStatus("Available");
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
	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public List<InventoryAccessories> getAllAccessories(){
//		return repository.findAll();
//	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Iterable<InventoryAccessories> getPartsBelongingToTicket(HttpServletRequest request){
		String ticket_id = request.getHeader("x-ticket");
		if(ticket_id!=null) {
			Tickets t = ticketsRepository.findOne(ticket_id);
			String model = t.getModel_name();
			String brand = t.getBrand();
			String category = t.getProduct_category();
			String subCategory = t.getProduct_sub_category();
			if(subCategory!=null)
			return inventoryService.fetchMatchingAccessory(brand,category,subCategory,model);
			else return inventoryService.fetchMatchingAccessoryWithoutSubCategory(brand, category, model);

		}
		return null;
	}
}
