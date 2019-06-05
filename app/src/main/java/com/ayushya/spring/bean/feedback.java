package com.ayushya.spring.bean;

import org.springframework.data.annotation.Id;

import com.mongodb.BasicDBObject;

public class feedback {
	
	@Id
	public String _id;
	public String user_id;
	public String ticket_number;
	public String rating;
	public String comments;
	public BasicDBObject answers;
	
	public feedback() {
		
	}

	public feedback(String _id, String user_id, String ticket_number, String rating, String comments,
			BasicDBObject answers) {
		super();
		this._id = _id;
		this.user_id = user_id;
		this.ticket_number = ticket_number;
		this.rating = rating;
		this.comments = comments;
		this.answers = answers;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getTicket_number() {
		return ticket_number;
	}

	public void setTicket_number(String ticket_number) {
		this.ticket_number = ticket_number;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public BasicDBObject getAnswers() {
		return answers;
	}

	public void setAnswers(BasicDBObject answers) {
		this.answers = answers;
	}

	
}
