package com.ayushya.spring.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ayushya.spring.bean.technician;
import com.ayushya.spring.bean.tickets;
import com.ayushya.spring.repository.technicianRepository;
import com.ayushya.spring.repository.ticketsRepository;
import com.ayushya.spring.service.AssignService;
import com.ayushya.spring.service.NextSequenceService;
import com.ayushya.spring.service.TicketService;
import com.ayushya.spring.service.closedTicketService;

@RestController
@RequestMapping("/tickets")
public class ticketsController {
	
	private static List<technician> SE = new ArrayList<technician>();
	@Autowired
	private ticketsRepository repository;

	@Autowired
	private technicianRepository technicianRepository;
	
	@Autowired
	private NextSequenceService nextSequenceService;

	@Autowired
	private TicketService ticketService;
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Iterable<tickets> getAllTickets(Pageable pageable){
		return repository.findAll(pageable);
	}

	@RequestMapping(value = "/{_id}", method = RequestMethod.GET)
	public tickets getOneTicket(@PathVariable String _id) {
		return repository.findOne(_id);
	}
	
	@RequestMapping(value = "/closed", method = RequestMethod.GET)
	public List<tickets> getClosedTickets(){
		return new closedTicketService().getClosedTickets(repository.findAll());
	}
	
	@RequestMapping(value = "/city/{city_filter}", method = RequestMethod.GET)
	public Iterable<tickets> getTicketsInCity(@PathVariable String city_filter,Pageable pageable){
		return (Iterable<tickets>) repository.findByCity(city_filter,pageable);
	}
	
	@RequestMapping(value = "/visit_date/{visit_date}", method = RequestMethod.GET)
	public Iterable<tickets> getTicketsBasedOnVisitDate(@PathVariable String visit_date,Pageable pageable){
		return (Iterable<tickets>) repository.findTicketsByVisit_date(visit_date,pageable);
	}
	


	@RequestMapping(value = "/", method = RequestMethod.POST)
	public tickets createTicket(@Valid @RequestBody tickets tick) {
		tick.set_id(nextSequenceService.getNextSequence("customSequences",new SimpleDateFormat("ddMMyy").format(new Date())));
		tick.setDate_of_post(new SimpleDateFormat("ddMMyyhhmmss").format(new Date()));
		List<technician> data = ticketService.getEmployeeData(SE);
		String id = new AssignService().assignTicket(data, tick.getCity());
		if(id!=null) {
		tick.setTech_name(id);
		technician tech = new technician();
		tech = technicianRepository.findOne(id);
		tech.setNo_assigned(technicianRepository.findOne(id).getNo_assigned() + 1);
		technicianRepository.save(tech);
		}
		repository.save(tick);
		return tick;
	}
	
	@RequestMapping(value = "/{_id}", method = RequestMethod.PUT)
	public tickets updateTicket(@PathVariable String _id, @Valid @RequestBody tickets ticket) {
		ticket.set_id(_id);
		tickets t = repository.findOne(_id);
		ticket.setAddress_1(t.getAddress_1());
		ticket.setAddress_2(t.getAddress_2());
		ticket.setBrand(t.getBrand());
		ticket.setCall_type(t.getCall_type());
		ticket.setCity(t.getCity());
		ticket.setDate_of_post(t.getDate_of_post());
		ticket.setDealer_name(t.getDealer_name());
		ticket.setEmail_id(t.getEmail_id());
		ticket.setInvoice_number(t.getInvoice_number());
		ticket.setIw(t.getIw());
		ticket.setMobile_number_1(t.getMobile_number_1());
		ticket.setMobile_number_2(t.getMobile_number_2());
		ticket.setModel_name(t.getModel_name());
		ticket.setName(t.getName());
		ticket.setPin_code(t.getPin_code());
		ticket.setProduct_category(t.getProduct_category());
		ticket.setRemarks(t.getRemarks());
		ticket.setSerial_number(t.getSerial_number());
		ticket.setState(t.getState());
		ticket.setStreet(t.getStreet());
		ticket.setTech_name(t.getTech_name());
		ticket.setTicket_status(t.getTicket_status());
		ticket.setTime_of_visit(t.getTime_of_visit());
		ticket.setVisit_date(t.getVisit_date());
		ticket.setOtherDamages(ticket.getOtherDamages());
		return repository.save(ticket);
	}

}
