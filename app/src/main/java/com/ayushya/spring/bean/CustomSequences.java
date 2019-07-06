package com.ayushya.spring.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customSequences")
public class CustomSequences {
    @Id
    private String id;
    private int seq;
    private String date;
    
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public CustomSequences(String id, int seq,String date) {
		this.id = id;
		this.seq = seq;
		this.date = date;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}

// getters and setters
}