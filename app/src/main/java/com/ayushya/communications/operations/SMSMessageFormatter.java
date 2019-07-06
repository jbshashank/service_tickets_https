package com.ayushya.communications.operations;

import java.util.HashMap;

import org.springframework.stereotype.Component;

/**
 * 
 * @author Nagendra Kumar
 *
 */
@Component	
public class SMSMessageFormatter implements IMessageFormatter{

	
	/**
	 * default constructor
	 */
	public SMSMessageFormatter() {
		
	}
	
	/**
	 * formats message
	 */
	public String format(HashMap hashMapMessageProps) throws NotificationOperationException{
		return "";
	}
}
