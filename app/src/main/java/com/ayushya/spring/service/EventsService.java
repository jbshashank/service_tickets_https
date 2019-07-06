package com.ayushya.spring.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayushya.spring.bean.EventAttributes;
import com.ayushya.spring.bean.Events;
import com.ayushya.spring.bean.Tickets;
import com.ayushya.spring.repository.EventsRepository;
import com.ayushya.spring.repository.TechnicianRepository;

@Service
public class EventsService {
	@Autowired
	EventsRepository eventsRepository;
	
	enum eventAttributeName 
	{ 
	    RED, GREEN, BLUE; 
	} 

	enum eventAttributeAction
	{ 
	    RED, GREEN, BLUE; 
	} 
	
	
	
	public void populateEventsObject(Tickets orginal,Tickets current) {
		EventAttributes EA = new EventAttributes();
		ArrayList<EventAttributes> eventAttributes = new ArrayList<>();
		Events EV = eventsRepository.findOne(orginal.get_id());
		if(EV==null)
		{
		EV = new Events();
		}
		else
		{
		eventAttributes.addAll(EV.getEventAttributes());
		}
		if(!orginal.equals(current)) {
			EV.set_id(orginal.get_id());
			EV.setEventSourceId(orginal.get_id());
			((EventAttributes) EA).setEventAttributeTimestamp(new Date().toLocaleString());
			eventAttributes.add(EA);
			EV.setEventAttributes(eventAttributes);
		}
		eventsRepository.save(EV);
		
	}
	
	
	public void populateEventsStatus(Tickets original,String newStatus) {
		EventAttributes EA = new EventAttributes();
		ArrayList<EventAttributes> eventAttributes = new ArrayList<>();
		Events EV = eventsRepository.findOne(original.get_id());
		if(EV==null)
		{
		EV = new Events();
		EV.set_id(original.get_id());
		EV.setEventSourceId(original.get_id());
		}
		else
		{
		eventAttributes.addAll(EV.getEventAttributes());
		}
		if(!original.getTicket_status().equals(newStatus)) {
			
			((EventAttributes) EA).setEventAttributeTimestamp(new Date().toLocaleString());
			EA.setEventAttributeAction("Updated");
			EA.setEventAttributeChangedFrom(original.getTicket_status());
			EA.setEventAttributeChangedTo(newStatus);
			EA.setEventAttributeConfirmation("YES");
			EA.setEventAttributeName("Status");
			eventAttributes.add(EA);
			EV.setEventAttributes(eventAttributes);
		}
		eventsRepository.save(EV);
		
	}
	
	
	
}
