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
	
	
}
