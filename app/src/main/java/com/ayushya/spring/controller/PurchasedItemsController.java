package com.ayushya.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ayushya.spring.bean.Invoice;
import com.ayushya.spring.bean.PurchasedItems;
import com.ayushya.spring.repository.PurchasedItemsRepository;
import com.ayushya.spring.service.InvoiceService;

@RestController
@RequestMapping("/purchasedItems")
public class PurchasedItemsController {

	
	@Autowired
	private InvoiceService invoiceService;
	
//	@RequestMapping(value = "/{_id}", method = RequestMethod.POST)
//	public String createPurchasedItems(@PathVariable String _id,@Valid @RequestBody PurchasedItems items) {
//		items.set_id(_id);
//		repository.save(items);
//		return "{\"Updation\":\"SUCCESS\"}";
//	}
	@RequestMapping(value = "/tickets/closed/{ticket_id}", method = RequestMethod.POST)
	public String storePartsConsumed(@PathVariable String ticket_id,@Valid @RequestBody Invoice purchasedItems,HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {
		return invoiceService.saveConsumedParts(ticket_id,purchasedItems,httpServletRequest,httpServletResponse);
	}
	
}
