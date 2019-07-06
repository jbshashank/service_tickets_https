package com.ayushya.communications.operations;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

/**
 * 
 * @author Nagendra Kumar
 *
 */
@Component	
public class TwilioSMSChannelClient implements INotificationChannel{
	
	
	/** account sid **/
	private String accountSID = "";
	
	/** token **/
	private String accountTocken = "";
	
	/** from number **/
	private String from="";
	/**
	 * default constructor
	 */
	public TwilioSMSChannelClient() {
		
	}
	
	/**
	 * send
	 */
	public String sendNotification(HashMap hashMapMessageProperties) throws NotificationOperationException{	
		//Twilio.init(accountSID,accountTocken);
		
		/* Message message = Message.creator(new PhoneNumber("+"+hashMapMessageProperties.get("TO")),
				    new PhoneNumber("+"+from), ""+hashMapMessageProperties.get("MESSAGE")).create();
				    */
		//String str = "Please provide the OTO to service engineer ";
		//Message message = Message.creator(new PhoneNumber("+918904173832"),
		//	    new PhoneNumber("+"+from), ""+hashMapMessageProperties.get("MESSAGE")).create();
	//	System.out.println(message.getSid());
		//System.out.println(" mESSAGE SENT "+hashMapMessageProperties.get("MESSAGE"));
		return "SUCCESS";
	}

	/**
	 * @return the accountSID
	 */
	public String getAccountSID() {
		return accountSID;
	}

	/**
	 * @param accountSID the accountSID to set
	 */
	public void setAccountSID(String accountSID) {
		this.accountSID = accountSID;
	}

	/**
	 * @return the accountTocken
	 */
	public String getAccountTocken() {
		return accountTocken;
	}

	/**
	 * @param accountTocken the accountTocken to set
	 */
	public void setAccountTocken(String accountTocken) {
		this.accountTocken = accountTocken;
	}

	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}
}
