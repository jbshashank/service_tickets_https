package com.ayushya.communications.operations;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Nagendra Kumar
 *
 */
@Component	
public class SMSNotificationHandler implements INotificationHandler{
	
	/** Application Context **/
	@Autowired
	private ApplicationContext applicationContext;
	
	/** Message Formatter Registry **/
	private HashMap messageFormatterRegistry = null;
	
	/** message channel registry **/
	private HashMap messageChannelRegistry = null;
	
	/** channel type **/
	private static final String CHANNEL_TYPE="twilioSMSChannel";
	/**
	 * default constructor
	 */
	public SMSNotificationHandler() {
		
	}
	
	/**
	 * sends the notification
	 */
	public String sendNotification(HashMap hashMapMessageDetails, String eventType) throws NotificationOperationException{
		
		IMessageFormatter iMessageFormatter = null;
		INotificationChannel iNotificationChannel = null;
		String message="";
		System.out.println(" I AM HERE CHECK THIS "+eventType+":::::: "+messageFormatterRegistry);
	    if(messageFormatterRegistry.containsKey(eventType)) {
	    	iMessageFormatter = (IMessageFormatter)messageFormatterRegistry.get(eventType);
	    	message = iMessageFormatter.format(hashMapMessageDetails);
	    }
	    
	    System.out.println(" THE MESSAGE AFTER MESSGING IS "+eventType+":::::"+messageChannelRegistry);
	    if((message!=null && message.trim().length()>0) && messageChannelRegistry.containsKey(CHANNEL_TYPE)) {
	    	iNotificationChannel = (INotificationChannel)messageChannelRegistry.get(CHANNEL_TYPE);
	    	  System.out.println(" SENDING MEEEEEEEEEEEEEEEEEEEEE "+message +":::::"+messageChannelRegistry);
	    	iNotificationChannel.sendNotification(hashMapMessageDetails);
	    }
		
		return "SUCCESS";
	}

	/**
	 * @return the messageFormatterRegistry
	 */
	public HashMap getMessageFormatterRegistry() {
		return messageFormatterRegistry;
	}

	/**
	 * @param messageFormatterRegistry the messageFormatterRegistry to set
	 */
	public void setMessageFormatterRegistry(HashMap messageFormatterRegistry) {
		this.messageFormatterRegistry = messageFormatterRegistry;
	}

	/**
	 * @return the messageChannelRegistry
	 */
	public HashMap getMessageChannelRegistry() {
		return messageChannelRegistry;
	}

	/**
	 * @param messageChannelRegistry the messageChannelRegistry to set
	 */
	public void setMessageChannelRegistry(HashMap messageChannelRegistry) {
		this.messageChannelRegistry = messageChannelRegistry;
	}
	
}
