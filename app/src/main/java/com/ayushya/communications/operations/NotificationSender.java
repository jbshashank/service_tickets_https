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
public class NotificationSender {
	
	/** Application Context **/
	private ApplicationContext applicationContext;
	
	/** communication Handler **/
	//private CommunicationHandler communicationHandler = null;
	
	@Autowired
	CommunicationHandler communicationHandler;
	/**
	 * default constructor
	 */
	public NotificationSender() {
		try {
			
			applicationContext = new ClassPathXmlApplicationContext("communication-config.xml");
			communicationHandler = (CommunicationHandler)applicationContext.getBean("communicationHandler");
		}catch(Exception exception) {
			exception.printStackTrace();
			
		}
	}
	
	/**
	 * notify messsage
	 */
	public void notify(HashMap messageProperties, String notificationType, String eventType) throws NotificationOperationException{
		communicationHandler.sendMessage(messageProperties, notificationType, eventType);
	}

}
