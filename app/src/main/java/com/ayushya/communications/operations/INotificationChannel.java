package com.ayushya.communications.operations;

import java.util.HashMap;

/**
 * 
 * @author Nagendra Kumar
 *
 */
public interface INotificationChannel {

	
	/**
	 * send Notification
	 */
	public String sendNotification(HashMap messageProps) throws NotificationOperationException;
}
