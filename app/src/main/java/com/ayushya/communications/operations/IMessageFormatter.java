package com.ayushya.communications.operations;

import java.util.HashMap;

/**
 * 
 * @author Nagendra Kumar
 *
 */
public interface IMessageFormatter {

	
	/** formate message **/
	public String format(HashMap messageProperties) throws NotificationOperationException;
}
