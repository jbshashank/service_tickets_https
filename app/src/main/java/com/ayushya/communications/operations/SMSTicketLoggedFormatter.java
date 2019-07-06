package com.ayushya.communications.operations;

import java.util.HashMap;

/**
 * 
 * @author Nagendra Kumar
 *
 */
public class SMSTicketLoggedFormatter implements IMessageFormatter{
	
	/** message formatter **/
	private String messageExpression = null;
	
	/**
	 * default constructor
	 */
	public SMSTicketLoggedFormatter() {
		
	}

	/**
	 * @return the messageExpression
	 */
	public String getMessageExpression() {
		return messageExpression;
	}

	/**
	 * @param messageExpression the messageExpression to set
	 */
	public void setMessageExpression(String messageExpression) {
		this.messageExpression = messageExpression;
	}

	@Override
	public String format(HashMap messageProperties) throws NotificationOperationException {
		// TODO Auto-generated method stub
		String formattedMessage = ""+messageExpression;
		System.out.println(" THE MESSSSSSSSSSSSSSSSSSSSSSSSSSSSS "+messageProperties);
		if(messageProperties.containsKey("$serviceRequest")) {
			formattedMessage = formattedMessage.replace("#serviceRequest", ""+messageProperties.get("$serviceRequest"));
			System.out.println(" THE MESSSSSSSSSSSSSSSSSSSSSSSSSSSSS <<<<11>>>"+formattedMessage);
		}
		if(messageProperties.containsKey("$serviceEngineer")) {
			formattedMessage = formattedMessage.replace("#serviceEngineer", ""+messageProperties.get("$serviceEngineer"));
			System.out.println(" THE MESSSSSSSSSSSSSSSSSSSSSSSSSSSSS <<<<2222222222>>>"+formattedMessage);
		}
		if(messageProperties.containsKey("$OTP")) {
			formattedMessage = formattedMessage.replaceAll("#OTP", ""+messageProperties.get("$OTP"));
		}
		if(messageProperties.containsKey("$Customer")) {
			formattedMessage = formattedMessage.replaceAll("#Customer", ""+messageProperties.get("$Customer"));
		}
		messageProperties.put("MESSAGE",""+formattedMessage);
		System.out.println(" messageProperties << messageProperties >> "+messageProperties);
		System.out.println(" OTP SEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE NT IS =========> "+formattedMessage);
		return "SUCCESS";
	}

	
}
