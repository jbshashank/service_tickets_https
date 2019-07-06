package com.ayushya.spring.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.json.simple.JSONObject;

import com.ayushya.spring.helper.GlobalConstants;
import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

public class EmailService {

	public boolean sendEmail() {
		Email from = new Email("shreyas.shivajirao@gmail.com");
		String subject = "Test email from shreyas";
		Email to = new Email("shreyas.shivajirao@gmail.com");
		Content content = new Content("text/plain", "Trying to send it for the first time");
		Mail mail = new Mail(from, subject, to, content);
		
		SendGrid sg = new SendGrid(GlobalConstants.SENDGRID_TOKEN);
		Request request = new Request();
		try {
			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());
			Response response = sg.api(request);
			System.out.println(response.getStatusCode());
			System.out.println(response.getBody());
			System.out.println(response.getHeaders());
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	public boolean sendEmailUsingSMTP(JSONObject mailsObject) throws AddressException, MessagingException {
		String emailPort = "587";
		Properties emailProperties = System.getProperties();
		emailProperties.put("mail.smtp.port", emailPort);
		emailProperties.put("mail.smtp.auth", "true");
		emailProperties.put("mail.smtp.starttls.enable", "true");
		
		String[] toEmails = { mailsObject.get("to").toString() };
		String emailSubject = mailsObject.get("subject").toString();
		String emailBody = mailsObject.get("body").toString();

		Session mailSession = Session.getDefaultInstance(emailProperties, null);
		MimeMessage emailMessage = new MimeMessage(mailSession);

		for (int i = 0; i < toEmails.length; i++) {
			emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmails[i]));
		}

		emailMessage.setSubject(emailSubject);
		emailMessage.setText(emailBody);
		
		String emailHost = "smtp.gmail.com";
		String fromUser = "trupthin.murthy";
		String fromUserEmailPassword = "Cheeku@98";

		Transport transport = mailSession.getTransport("smtp");

		transport.connect(emailHost, fromUser, fromUserEmailPassword);
		transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
		transport.close();
		System.out.println("Email sent successfully.");
		return true;
	}
	
}
