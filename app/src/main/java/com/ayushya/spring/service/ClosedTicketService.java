package com.ayushya.spring.service;

import java.util.ArrayList;
import java.util.List;

import com.ayushya.spring.bean.Tickets;

public class ClosedTicketService {
	
	public List<Tickets> getClosedTickets(List<Tickets> allTickets) {
		List<Tickets> closedTickets = new ArrayList<Tickets>();
		for(int i = 0;i < allTickets.size();i++) {
			if(allTickets.get(i).getTicket_status().equals("Closed")) {
				Tickets tick = allTickets.get(i);
				System.out.println(tick.get_id());
				closedTickets.add(tick);
			}
		}
		return closedTickets;
	}

}
