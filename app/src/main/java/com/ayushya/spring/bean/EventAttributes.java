package com.ayushya.spring.bean;

public class EventAttributes {

	private String eventAttributeName;
	private String eventAttributeAction;
	private String eventAttributeTimestamp;
	private String eventAttributeChangedFrom;
	private String eventAttributeChangedTo;
	private String eventAttributeConfirmation;
	private String eventAttributeChangeReason;
	
	public EventAttributes(String eventAttributeName, String eventAttributeAction, String eventAttributeTimestamp,
			String eventAttributeChangedFrom, String eventAttributeChangedTo, String eventAttributeConfirmation,String eventAttributeChangeReason) {
		super();
		this.eventAttributeName = eventAttributeName;
		this.eventAttributeAction = eventAttributeAction;
		this.eventAttributeTimestamp = eventAttributeTimestamp;
		this.eventAttributeChangedFrom = eventAttributeChangedFrom;
		this.eventAttributeChangedTo = eventAttributeChangedTo;
		this.eventAttributeConfirmation = eventAttributeConfirmation;
		this.setEventAttributeChangeReason(eventAttributeChangeReason);
	}

	public EventAttributes() {
		// TODO Auto-generated constructor stub
	}

	public String getEventAttributeName() {
		return eventAttributeName;
	}

	public void setEventAttributeName(String eventAttributeName) {
		this.eventAttributeName = eventAttributeName;
	}

	public String getEventAttributeAction() {
		return eventAttributeAction;
	}

	public void setEventAttributeAction(String eventAttributeAction) {
		this.eventAttributeAction = eventAttributeAction;
	}

	public String getEventAttributeTimestamp() {
		return eventAttributeTimestamp;
	}

	public void setEventAttributeTimestamp(String eventAttributeTimestamp) {
		this.eventAttributeTimestamp = eventAttributeTimestamp;
	}

	public String getEventAttributeChangedFrom() {
		return eventAttributeChangedFrom;
	}

	public void setEventAttributeChangedFrom(String eventAttributeChangedFrom) {
		this.eventAttributeChangedFrom = eventAttributeChangedFrom;
	}

	public String getEventAttributeChangedTo() {
		return eventAttributeChangedTo;
	}

	public void setEventAttributeChangedTo(String eventAttributeChangedTo) {
		this.eventAttributeChangedTo = eventAttributeChangedTo;
	}

	public String getEventAttributeConfirmation() {
		return eventAttributeConfirmation;
	}

	public void setEventAttributeConfirmation(String eventAttributeConfirmation) {
		this.eventAttributeConfirmation = eventAttributeConfirmation;
	}

	public String getEventAttributeChangeReason() {
		return eventAttributeChangeReason;
	}

	public void setEventAttributeChangeReason(String eventAttributeChangeReason) {
		this.eventAttributeChangeReason = eventAttributeChangeReason;
	}	
	
}
