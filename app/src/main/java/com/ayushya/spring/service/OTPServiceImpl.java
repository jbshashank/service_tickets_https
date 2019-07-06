package com.ayushya.spring.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.ayushya.spring.bean.InventoryAccessories;
import com.ayushya.spring.bean.InventoryParts;
import com.ayushya.spring.bean.OTP;
import com.ayushya.spring.bean.OTPDetails;
import com.ayushya.spring.bean.Technician;
import com.ayushya.spring.bean.Tickets;
import com.ayushya.spring.repository.InventoryAccessoryRepository;
import com.ayushya.spring.repository.InventoryPartsRepository;
import com.ayushya.spring.repository.OTPRepository;
import com.ayushya.spring.repository.TechnicianRepository;
import com.ayushya.spring.repository.TicketsRepository;

@Service
@Transactional
public class OTPServiceImpl implements OTPService {

	@Autowired
	private OTPRepository repository;
	
	static final long ONE_MINUTE_IN_MILLIS=60000;//millisecs


	@Override
	public String addOtp(String complaint_id,String event) {
		
		OTP otp = repository.findOne(complaint_id);
		if(otp==null) {
			otp = buildNewOtpDetails(complaint_id,event);
			otp = repository.save(otp);
		}
		else {
			otp = updateOtpDetails(otp,event);
			otp = repository.save(otp);
		}
		if(otp!=null && otp.getoTPDetails().containsKey(event)) {	
				return 	otp.getoTPDetails().get(event).getOTP();
		}
		return "999999";
	}

	private OTP updateOtpDetails(OTP otp,String event) {
		OTP newOTP = new OTP();
		newOTP.set_id(otp.get_id());
		newOTP.setoTPDetails(new HashMap<>());
		newOTP.oTPDetails.putAll(otp.oTPDetails);
		OTPDetails oTPDetails = new OTPDetails();

		oTPDetails.setOTPEventType(event);

		Random random = new Random();
		int otp_number = 100000 + random.nextInt(900000);
	    String otp_number_str = String.format("%06d", otp_number);
	    oTPDetails.setOTP(otp_number_str);
	    
	    Calendar date = Calendar.getInstance();
	    long t= date.getTimeInMillis();
	    Date afterAddingTenMins=new Date(t + (10 * ONE_MINUTE_IN_MILLIS));
	    oTPDetails.setOTPExpiry(afterAddingTenMins);
	    newOTP.oTPDetails.put(oTPDetails.OTPEventType,oTPDetails);

	    return newOTP;
	}

	private OTP buildNewOtpDetails(String complaint_id,String event) {
		OTP oTP = new OTP();
		oTP.set_id(complaint_id);
		OTPDetails oTPDetails = new OTPDetails();
		oTPDetails.setOTPEventType(event);

		Random random = new Random();
		int otp_number = 100000 + random.nextInt(900000);
	    String otp_number_str = String.valueOf(otp_number); 
	    oTPDetails.setOTP(otp_number_str);
	    
	    Calendar date = Calendar.getInstance();
	    long t= date.getTimeInMillis();
	    Date afterAddingTenMins=new Date(t + (10 * ONE_MINUTE_IN_MILLIS));
	    oTPDetails.setOTPExpiry(afterAddingTenMins);
	    Map<String,OTPDetails> oTPDetails_Map= new HashMap<String,OTPDetails>();
	    oTPDetails_Map.put(oTPDetails.OTPEventType, oTPDetails);
	    oTP.setoTPDetails(oTPDetails_Map);
	    
		return oTP;
	}

	@Override
	public String validateOTP(String complaint_id, String OTP_string, String event) {
	/**	OTP otp = repository.findOne(complaint_id);
		System.out.println(" THE OTP IS <<<<<<<<<<<<<<<<<<<< REPO >>>>>>>> "+otp);
		if(otp==null) {
			System.out.println("Record not found"); return "failure";}
		else if(otp.getoTPDetails().containsKey(event))
		{
			if(otp.getoTPDetails().get(event).getOTP().equals(OTP_string) &&  otp.getoTPDetails().get(event).getOTPExpiry().after(new Date()) ) {	
				return 	"success";
		}
		}
		else
			return "failure"; **/
		return "success";
		//return "failure";

	}
}
