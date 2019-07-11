package com.ayushya.spring.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ayushya.spring.bean.Technician;
import com.ayushya.spring.bean.Tickets;
import com.ayushya.spring.repository.TechnicianRepository;
import com.ayushya.spring.repository.TicketsRepository;
import com.ayushya.spring.service.AssignService;
import com.ayushya.spring.service.NextSequenceService;
import com.ayushya.spring.service.TicketService;
import com.ayushya.spring.service.ClosedTicketService;

@RestController
@RequestMapping("/tickets")
public class TicketsController
{

	private static List<Technician> SE = new ArrayList<Technician>();
	@Autowired
	private TicketsRepository repository;

	@Autowired
	private TechnicianRepository technicianRepository;

	@Autowired
	private NextSequenceService nextSequenceService;

	@Autowired
	private TicketService ticketService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Tickets>> getAllTickets(HttpServletRequest request, HttpServletResponse response,Pageable pageable)
	{
		System.out.println(" REached Service");
		String user = request.getHeader("x-userid");
		Iterable<Tickets> t =null;
		if(user!=null)
		t =repository.findTicketsByUser(user,pageable);
		else
		t =repository.findAll(pageable);	
		return ResponseEntity.accepted().body(t);
	}
	
	@RequestMapping(value = "/{status}", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Tickets>> getAllTicketsByStatus(@PathVariable String status,HttpServletRequest request, HttpServletResponse response,Pageable pageable,@RequestParam("user") String user)
	{
		Iterable<Tickets> t =repository.findTicketsByUserAndTicketStatus(user,status,pageable);
		return ResponseEntity.accepted().body(t);
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Tickets> getAllTickets1(@RequestParam("status") String status,
			Pageable pageable)
	{

		return filterTickets(status, repository.findAll(pageable));

	}

	/**
	 * filter ticket
	 * 
	 * @param _id
	 * @return
	 */
	private List<Tickets> filterTickets(String status,
			Iterable<Tickets> iterTickets)
	{

		Iterator ticketsIter = iterTickets.iterator();
		Tickets tkt = null;
		List<Tickets> lstTickets = new ArrayList<Tickets>();
		while (ticketsIter.hasNext())
		{
			tkt = (Tickets) ticketsIter.next();
			if (tkt.getTicket_status() != null
					&& tkt.getTicket_status()
					.equalsIgnoreCase(status))
			{
				lstTickets.add(tkt);
			}
		}

		return lstTickets;

	}

	@RequestMapping(value = "/{_id}", method = RequestMethod.GET)
	public Tickets getOneTicket(@PathVariable String _id)
	{
		return repository.findOne(_id);
	}

// 	@RequestMapping(value = "/closed", method = RequestMethod.GET)
// 	public List<Tickets> getClosedTickets()
// 	{
// 		return new ClosedTicketService().getClosedTickets(repository.findAll());
// 	}

	@RequestMapping(value = "/city/{city_filter}", method = RequestMethod.GET)
	public Iterable<Tickets> getTicketsInCity(@PathVariable String city_filter,
			Pageable pageable)
	{
		return (Iterable<Tickets>) repository.findByCity(city_filter, pageable);
	}

	@RequestMapping(value = "/visit_date/{visit_date:.+}", method = RequestMethod.GET)
	public Iterable<Tickets> getTicketsBasedOnVisitDate(@PathVariable("visit_date") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'") Date visit_date,
			Pageable pageable)
	{
		return (Iterable<Tickets>) repository.findTicketsByVisit_date(visit_date, pageable);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Tickets createTicket(@Valid @RequestBody Tickets tick) throws ParseException
	{
		tick.set_id(nextSequenceService.getNextSequence("customSequences",
				new SimpleDateFormat("ddMMyy").format(new Date())));
		tick.setTicket_status("reported");
		tick.setDate_of_post(new SimpleDateFormat("ddMMyyhhmmss").format(new Date()));
		Technician technician = ticketService.getEmployeeData(tick);
		if(technician!=null) {
		tick.setTech_name(technician.getSeName());
		tick.setTechnicianUniqueId(technician.getSeUniqueId()); 
		if(tick.getTech_name()!=null)tick.setTicket_status("open");
		}
		repository.save(tick);
		return tick;
	}

	@RequestMapping(value = "/ticket/{ticket_id}/{status}", method = RequestMethod.PUT)
	public ResponseEntity<Tickets> updateTicketStatus(@PathVariable String ticket_id,@PathVariable String status,@PathVariable String reason)
	{
		Tickets t = ticketService.updateTicketStatus(ticket_id,status,null);
		return ResponseEntity.accepted().body(t);
	}
	
	@RequestMapping(value = "/ticket/{ticket_id}/{status}/{reason}", method = RequestMethod.PUT)
	public ResponseEntity<Tickets> updateTicketStatusreason(@PathVariable String ticket_id,@PathVariable String status,@PathVariable String reason)
	{
		Tickets t = ticketService.updateTicketStatus(ticket_id,status,reason);
		return ResponseEntity.accepted().body(t);
	}

	@RequestMapping(value = "/{_id}", method = RequestMethod.PUT)
	public Tickets updateTicket(@PathVariable String _id, @Valid @RequestBody Tickets ticket) {
		return ticketService.updateTicket(_id,ticket);
	}
}
