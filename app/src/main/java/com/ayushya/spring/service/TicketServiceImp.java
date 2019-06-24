package com.ayushya.spring.service;

import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.ayushya.spring.bean.technician;
import com.ayushya.spring.bean.tickets;
import com.ayushya.spring.repository.technicianRepository;
import com.ayushya.spring.repository.ticketsRepository;

@Service
@Transactional
public class TicketServiceImp implements TicketService {
	@Autowired
	ticketsRepository ticketRepository;

	@Autowired
	technicianRepository technicianRepository;
	
	@Autowired
	EventsService eventsService;
	
	@Override
	public void createTicket(List<tickets> ticket) {
		// TODO Auto-generated method stub
		ticketRepository.save(ticket);
	}

	@Cacheable("technicians")
	public List<technician> getEmployeeData(List<technician> sE) {
		JSONArray jsonarray = new JSONArray(new RestTemplate().getForObject("https://services-1.finchtech.in/Employee/user/get", String.class));
		for(int i=0; i<jsonarray.length(); i++){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        org.json.JSONObject obj = jsonarray.getJSONObject(i).getJSONObject("employeePersonalDetails");
	        technician Se = new technician();
	        Se.set_id(jsonarray.getJSONObject(i).getString("id"));
	        Se.setCity(obj.getString("city"));
	        Se.setPin_code(obj.getString("pincode"));
	        Se.setLevel_of_expertise(obj.getString("expertiesLevel"));
	        Se.setAddress(obj.getString("address"));
	        sE.add(Se); 
	        technicianRepository.save(Se);
	    }
		return technicianRepository.findAll(); 
	}

	@Override
	public tickets updateTicketStatus(String ticket_id,String status) {
		tickets t = ticketRepository.findOne(ticket_id);
		if(t!=null)
		{
			eventsService.populateEventsStatus(t, status);
			t.setTicket_status(status);
		}
		return ticketRepository.save(t);
	}
	
	
	@Override
	public tickets updateTicket(String ticket_id,tickets t) {
		tickets ticket = ticketRepository.findOne(ticket_id);
		ticket.set_id(ticket_id);
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
		ticket.setVisit_time(t.getVisit_time());
		ticket.setOtherDamages(ticket.getOtherDamages());
		eventsService.populateEventsObject(ticket,t);
		return ticketRepository.save(ticket);		
	}
	
	
}
