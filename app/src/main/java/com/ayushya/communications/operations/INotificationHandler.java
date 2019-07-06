package com.ayushya.communications.operations;

import java.util.HashMap;

/**
 * 
 * @author Nagendra Kumar
 *
 */
public interface INotificationHandler {

	
	/** send notification **/
	public String sendNotification(HashMap messageProperties, String eventType) throws NotificationOperationException;
}
