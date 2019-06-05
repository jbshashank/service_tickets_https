package com.ayushya.spring.service;

import java.util.ArrayList;
import java.util.List;

import com.ayushya.spring.bean.tickets;

public class closedTicketService {
	
	public List<tickets> getClosedTickets(List<tickets> allTickets) {
		List<tickets> closedTickets = new ArrayList<tickets>();
		for(int i = 0;i < allTickets.size();i++) {
			if(allTickets.get(i).getTicket_status().equals("Closed")) {
				tickets tick = allTickets.get(i);
				System.out.println(tick.get_id());
				closedTickets.add(tick);
			}
		}
		return closedTickets;
	}

}
