package com.ayushya.spring.service;

import java.util.List;

import com.ayushya.spring.bean.Technician;
import com.ayushya.spring.bean.Tickets;


public interface TicketService {
	public void createTicket(List<Tickets> ticket);

	public Technician getEmployeeData(Tickets ticket);

	public Tickets updateTicketStatus(String ticket_id, String status);

	Tickets updateTicket(String ticket_id, Tickets t);
}
