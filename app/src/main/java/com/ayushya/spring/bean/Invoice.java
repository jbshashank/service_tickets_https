package com.ayushya.spring.bean;

import java.util.Date;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mongodb.BasicDBList;

public class Invoice {
	
//	{
//		  "lstItemDetails" : [ {
//		    "partId" : "part123",
//		    "partName" : "IC23001",
//		    "quantity" : "10",
//		    "quote" : "200",
//		    "type" : "PART"
//		  }, {
//		    "partId" : "AC123",
//		    "partName" : "TV Cover",
//		    "quantity" : "2",
//		    "quote" : "100",
//		    "type" : "ACCESS"
//		  } ],
//		  "paymentMode" : "PAYTM",
//		  "totalAmount" : "20000",
//		  "submittedDate" : "12-Jul-2019",
//		  "ticketId" : "TICKET2000",
//		  "coupponId" : "COUP123",
//		  "serviceCharges" : "200"
//		}

	@Id
	public String _id;
	public String ticketId;
	public float totalAmount;
	public String coupponId;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy") 
	public Date submittedDate;
	public String paymentMode;
	public int serviceCharges;
	public BasicDBList lstItemDetails;
	
	public Invoice() {
		
	}

	public Invoice(String _id, String ticketId, float totalAmount, String coupponId, Date submittedDate,
			String paymentMode, int serviceCharges, BasicDBList lstItemDetails) {
		super();
		this._id = _id;
		this.ticketId = ticketId;
		this.totalAmount = totalAmount;
		this.coupponId = coupponId;
		this.submittedDate = submittedDate;
		this.paymentMode = paymentMode;
		this.serviceCharges = serviceCharges;
		this.lstItemDetails = lstItemDetails;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getCoupponId() {
		return coupponId;
	}

	public void setCoupponId(String coupponId) {
		this.coupponId = coupponId;
	}

	public Date getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public int getServiceCharges() {
		return serviceCharges;
	}

	public void setServiceCharges(int serviceCharges) {
		this.serviceCharges = serviceCharges;
	}

	public BasicDBList getItems() {
		return lstItemDetails;
	}

	public void setItems(BasicDBList items) {
		this.lstItemDetails = lstItemDetails;
	}
	

}
