package com.ayushya.communications.operations;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Nagendra Kumar
 *
 */
@Component	
public class CommunicationHandler {
	
	/** notification handler **/
	private INotificationHandler iNotificationHandler = null;
	
	
	private HashMap notificationHandlerRegistry = null;
	
	/**
	 * default constructor
	 */
	public CommunicationHandler() {
		
		
	}
	
	/**
	 * init method
	 */
	public void init() {
		
	}
	
	/**
	 * send message
	 */
	public void sendMessage(HashMap messageProperties, String notificationType,String eventType) throws NotificationOperationException{
		
		if(notificationHandlerRegistry.containsKey(notificationType)) {
			System.out.println(" MESSAGE PROPERTIES TO AYUSHA "+messageProperties);
			System.out.println(" THE MESSAGE IS "+eventType+"::::: "+notificationHandlerRegistry);
			iNotificationHandler = (INotificationHandler)notificationHandlerRegistry.get(notificationType);
			System.out.println(" THE MESSAGE IS <<iNotificationHandler>>"+iNotificationHandler);
			iNotificationHandler.sendNotification(messageProperties, eventType);
		}
	}

	/**
	 * @return the notificationHandlerRegistry
	 */
	public HashMap getNotificationHandlerRegistry() {
		return notificationHandlerRegistry;
	}

	/**
	 * @param notificationHandlerRegistry the notificationHandlerRegistry to set
	 */
	public void setNotificationHandlerRegistry(HashMap notificationHandlerRegistry) {
		this.notificationHandlerRegistry = notificationHandlerRegistry;
	}
}
