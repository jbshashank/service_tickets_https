package com.ayushya.spring.service;

import java.util.List;

import com.ayushya.spring.bean.technician;
import com.ayushya.spring.bean.tickets;


public interface TicketService {
	public void createTicket(List<tickets> ticket);

	public List<technician> getEmployeeData(List<technician> sE);
}
