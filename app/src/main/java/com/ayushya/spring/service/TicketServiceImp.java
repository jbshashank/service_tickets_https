package com.ayushya.spring.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.ayushya.communications.operations.NotificationOperationException;
import com.ayushya.communications.operations.NotificationSender;
import com.ayushya.spring.bean.Technician;
import com.ayushya.spring.bean.Tickets;
import com.ayushya.spring.repository.TechnicianRepository;
import com.ayushya.spring.repository.TicketsRepository;

@Service
@Transactional
public class TicketServiceImp implements TicketService {
	@Autowired
	TicketsRepository ticketRepository;

	@Autowired
	TechnicianRepository technicianRepository;
	
	@Autowired
	EventsService eventsService;
	
	@Autowired
	NotificationSender notificationSender;
	
	@Autowired
	OTPService oTPService;
	

	public void createTicket(List<Tickets> ticket) {
		// TODO Auto-generated method stub
		ticketRepository.save(ticket);
	}

	public Technician getEmployeeData(Tickets ticket) {
		List<Technician> technicianList = getEmployeeDataFromService();
		for(Technician t:technicianList)
			if(t.pin_code.equals(ticket.pin_code)) return t;
		return null;
	}
	@Cacheable("technicians")
	public List<Technician> getEmployeeDataFromService() {
		List<Technician> technicianList = new ArrayList<Technician>();
		try {
		JSONArray jsonarray = new JSONArray(new RestTemplate().getForObject("https://services-1.finchtech.in/Employee/user/get", String.class));
		if(jsonarray!=null) {
		for(int i=0; i<jsonarray.length(); i++){
	        org.json.JSONObject obj = jsonarray.getJSONObject(i).getJSONObject("employeePersonalDetails");
	        Technician Se = new Technician();
	        Se.set_id(jsonarray.getJSONObject(i).getString("id"));
	        Se.setSeName(obj.getString("empFirstName")+" "+obj.getString("empLastName"));
	        Se.setSeUniqueId(obj.getString("empEmailAddress"));
	        Se.setCity(obj.getString("city"));
	        Se.setPin_code(obj.getString("pincode"));
	        Se.setLevel_of_expertise(obj.getString("expertiesLevel"));
	        Se.setAddress(obj.getString("address"));
	        technicianList.add(Se);
	        technicianRepository.save(Se);
	    }
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return technicianRepository.findAll(); 
	}

	
	public Tickets updateTicketStatus(String ticket_id,String status,String reason) {
		Tickets t = ticketRepository.findOne(ticket_id);
		if(t!=null)
		{
			//eventsService.populateEventsStatus(t, status);
			eventsService.populateEventsStatusReason(t,status,reason);
			t.setTicket_status(status);
			if(t.brand!=null && t.model_name !=null && t.product_category!=null)
				t = ticketRepository.save(t);
		}
		
		try {
			sendNotifications(t,status);
		} catch (NotificationOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return t;
	}
	
	
	
	public Tickets updateTicket(String ticket_id,Tickets t) {
		Tickets ticket = ticketRepository.findOne(ticket_id);
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
		//ticket.setTicket_status(t.getTicket_status());
		ticket.setVisit_time(t.getVisit_time());
		ticket.setOtherDamages(ticket.getOtherDamages());
		eventsService.populateEventsObject(ticket,t);
		
		if(t.brand!=null && t.model_name !=null && t.product_category!=null)
			ticket = ticketRepository.save(ticket);	
		return ticket;
	}
	
	
private void sendNotifications(Tickets t,String status) throws NotificationOperationException {
	HashMap<String,String> hashMapMessageProps = null;
	HashMap<String,String> hashMapEmailProps = null;
	hashMapMessageProps = new HashMap<>();
	hashMapEmailProps = new HashMap<>();
	notificationSender = new NotificationSender();

	switch(status) 
    { 
        case "open": 	
        	
        	hashMapMessageProps.put("TO", t.getMobile_number_1());
        	hashMapMessageProps.put("$Customer", t.getName());
    		hashMapMessageProps.put("$serviceRequest", "GREETINGS FROM AUSHA");
    		hashMapMessageProps.put("$serviceEngineer", t.getTech_name());
    		notificationSender.notify(hashMapMessageProps, "sms", "smsTicketLoggedFormatter_ticketcreated");

    		hashMapEmailProps.put("TO", t.getEmail_id());
    		hashMapEmailProps.put("$serviceRequest", "GREETINGS FROM AUSHA");
    		hashMapEmailProps.put("$Customer", t.getName());
    		hashMapEmailProps.put("$serviceEngineer", t.getTech_name());
    		hashMapEmailProps.put("SUBJECT", "testing");
			notificationSender.notify(hashMapEmailProps, "email", "emailTicketLoggedFormatter_ticketcreated");
            break; 
            
        case "accepted": 	
        	
        	hashMapMessageProps.put("TO", t.getMobile_number_1());
        	hashMapMessageProps.put("$Customer", t.getName());
    		hashMapMessageProps.put("$serviceRequest", "GREETINGS FROM AUSHA");
    		hashMapMessageProps.put("$serviceEngineer", t.getTech_name());
    		notificationSender.notify(hashMapMessageProps, "sms", "smsTicketLoggedFormatter_ticketcreated");

    		hashMapEmailProps.put("TO", t.getEmail_id());
    		hashMapEmailProps.put("$serviceRequest", "GREETINGS FROM AUSHA");
    		hashMapEmailProps.put("$Customer", t.getName());
    		hashMapEmailProps.put("$serviceEngineer", t.getTech_name());
    		hashMapEmailProps.put("SUBJECT", "testing");
			notificationSender.notify(hashMapEmailProps, "email", "emailTicketLoggedFormatter_ticketcreated");
            break;
            
        case "in-progress": 
        	hashMapMessageProps.put("TO", t.getMobile_number_1());
    		hashMapMessageProps.put("$serviceRequest", "GREETINGS FROM AUSHA");
        	hashMapMessageProps.put("$Customer", t.getName());
    		hashMapMessageProps.put("$serviceEngineer", t.getTech_name());
    		String OTP_NUMBER_started = oTPService.addOtp(t.get_id(),"start_otp");
    		hashMapMessageProps.put("$OTP", OTP_NUMBER_started);
    		notificationSender.notify(hashMapMessageProps, "sms", "smsTicketLoggedFormatter_ticketopened");
    		
    		hashMapEmailProps.put("TO", t.getEmail_id());
    		hashMapEmailProps.put("$serviceRequest", "GREETINGS FROM AUSHA");
    		hashMapEmailProps.put("$Customer", t.getName());
    		hashMapEmailProps.put("$OTP", OTP_NUMBER_started);
    		hashMapEmailProps.put("$serviceEngineer", t.getTech_name());
    		hashMapEmailProps.put("SUBJECT", "testing");
			notificationSender.notify(hashMapEmailProps, "email", "emailTicketLoggedFormatter_ticketopened");
            break; 
            
        case "reschedule": 
        	hashMapMessageProps.put("TO", t.getMobile_number_1());
    		hashMapMessageProps.put("$serviceRequest", "GREETINGS FROM AUSHA");
    		hashMapMessageProps.put("$Customer", t.getName());
    		hashMapMessageProps.put("$serviceEngineer", t.getTech_name());
    		notificationSender.notify(hashMapMessageProps, "sms", "smsTicketLoggedFormatter_customernotavailable");
    		
    		hashMapEmailProps.put("TO", "shashijb@gmail.com");
    		hashMapEmailProps.put("$serviceRequest", "GREETINGS FROM AUSHA");
    		hashMapEmailProps.put("$Customer", t.getName());
    		hashMapEmailProps.put("$serviceEngineer", t.getTech_name());
    		hashMapEmailProps.put("SUBJECT", "testing");
			notificationSender.notify(hashMapEmailProps, "email", "emailTicketLoggedFormatter_ticketopened");
            break; 
            
        case "estimated": 
        	hashMapMessageProps.put("TO", t.getMobile_number_1());
    		hashMapMessageProps.put("$serviceRequest", "GREETINGS FROM AUSHA");
    		hashMapMessageProps.put("$serviceEngineer", t.getTech_name());
    		hashMapMessageProps.put("$Customer", t.getName());
    		String OTP_NUMBER_estimate_approval = oTPService.addOtp(t.get_id(),"estimate_approval");
    		hashMapMessageProps.put("$OTP", OTP_NUMBER_estimate_approval);
    		notificationSender.notify(hashMapEmailProps, "sms", "smsTicketLoggedFormatter_estimateapproval");
            break; 
            
        case "invoice_generated": 
        	hashMapMessageProps.put("TO", t.getMobile_number_1());
    		hashMapMessageProps.put("$serviceRequest", "GREETINGS FROM AUSHA");
    		hashMapMessageProps.put("$serviceEngineer", t.getTech_name());
    		hashMapMessageProps.put("$Customer", t.getName());
    		String OTP_NUMBER_invoice_generated = oTPService.addOtp(t.get_id(),"end_otp");
    		hashMapMessageProps.put("$OTP", OTP_NUMBER_invoice_generated);
    		notificationSender.notify(hashMapEmailProps, "sms", "smsTicketLoggedFormatter_invoicegenerated");
            break; 
            
        default: 
            System.out.println("Notification not required"); 
    } 

}
	
}
