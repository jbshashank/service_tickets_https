package com.ayushya.spring.bean;

import org.springframework.data.annotation.Id;

import com.mongodb.BasicDBObject;

public class logs {

	@Id
	public String _id;
	public String ticket_number;
	public String dateAndTime;
	public BasicDBObject logDetails;
	
	public logs() {
		
	}
	
	public logs(String _id, String ticket_number, String dateAndTime, BasicDBObject logDetails) {
		super();
		this._id = _id;
		this.ticket_number = ticket_number;
		this.dateAndTime = dateAndTime;
		this.logDetails = logDetails;
	}
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getTicket_number() {
		return ticket_number;
	}
	public void setTicket_number(String ticket_number) {
		this.ticket_number = ticket_number;
	}
	public String getDateAndTime() {
		return dateAndTime;
	}
	public void setDateAndTime(String dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public BasicDBObject getLogDetails() {
		return logDetails;
	}

	public void setLogDetails(BasicDBObject logDetails) {
		this.logDetails = logDetails;
	}
	
	
}
