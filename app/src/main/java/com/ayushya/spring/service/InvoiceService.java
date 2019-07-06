package com.ayushya.spring.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ayushya.spring.bean.Invoice;

public interface InvoiceService {

	public String generateInvoice(String ticket_id,HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) ;
	public String saveConsumedParts(String ticket_id,Invoice purchasedItems,HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse);
}
