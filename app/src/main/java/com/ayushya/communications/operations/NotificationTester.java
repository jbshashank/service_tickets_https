package com.ayushya.communications.operations;

import static org.hamcrest.CoreMatchers.not;

import java.util.HashMap;

/**
 * 
 * @author Nagendra Kumar
 *
 */
public class NotificationTester {

	
	/**
	 * default constructor
	 */
	public NotificationTester() {
		
	}
	
	/**
	 * test sms
	 */
	public void testSMS() {
		HashMap hashMapMessageProps = null;
		NotificationSender notificationSender = null;
		
		try {
			hashMapMessageProps = new HashMap();
			hashMapMessageProps.put("TO", "+918904173832");
			hashMapMessageProps.put("$serviceRequest", "GREETINGS FROM AUSHA");
			hashMapMessageProps.put("$serviceEngineer", "John Abrham");
			notificationSender = new NotificationSender();
			notificationSender.notify(hashMapMessageProps, "sms", "smsTicketLoggedFormatter");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * test sms
	 */
	public void testEmail() {
		HashMap hashMapMessageProps = null;
		NotificationSender notificationSender = null;
		
		try {
			hashMapMessageProps = new HashMap();
			hashMapMessageProps.put("TO", "shashijb@gmail.com");
			hashMapMessageProps.put("$serviceRequest", "GREETINGS FROM AUSHA");
			hashMapMessageProps.put("$serviceEngineer", "John Abrham");
			hashMapMessageProps.put("$Customer", "John Abrham");
			hashMapMessageProps.put("SUBJECT", "testing");
			notificationSender = new NotificationSender();
			notificationSender.notify(hashMapMessageProps, "email", "emailTicketLoggedFormatter_ticketcreated");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * main method
	 */
	public static void main(String[] args) {
		NotificationTester notificationTester = new NotificationTester();
		notificationTester.testEmail();
	}
}
