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

import com.ayushya.spring.bean.Feedback;
import com.ayushya.spring.bean.Invoice;
import com.ayushya.spring.bean.Tickets;
import com.ayushya.spring.repository.FeedbackRepository;
import com.ayushya.spring.service.ExcelService;
import com.ayushya.spring.service.InvoiceService;

@RestController
@RequestMapping("/Invoice")
public class InvoiceController {

	@Autowired
	InvoiceService invoiceService;

	
	@RequestMapping(value = "/{ticket_id}", method = RequestMethod.POST)
	public String createFeedback(@PathVariable String ticket_id,HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {
		return invoiceService.generateInvoice(ticket_id,httpServletRequest,httpServletResponse);
	}
	

	
}
