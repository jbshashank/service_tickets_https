package com.ayushya.spring.bean;

import java.util.List;

import org.springframework.data.annotation.Id;

import com.mongodb.BasicDBObject;

public class Events {

	@Id
	public String _id;
	public String eventSourceId;
	public List<EventAttributes> eventAttributes;  
	
	public Events() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Events(String _id, String eventSourceId, List<EventAttributes> eventAttributes) {
		super();
		this._id = _id;
		this.eventSourceId = eventSourceId;
		this.eventAttributes = eventAttributes;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getEventSourceId() {
		return eventSourceId;
	}

	public void setEventSourceId(String eventSourceId) {
		this.eventSourceId = eventSourceId;
	}

	public List<EventAttributes> getEventAttributes() {
		return eventAttributes;
	}

	public void setEventAttributes(List<EventAttributes> eventAttributes) {
		this.eventAttributes = eventAttributes;
	}

	




}
