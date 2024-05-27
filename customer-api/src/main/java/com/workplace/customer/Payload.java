package com.workplace.customer;



public class Payload {
	private String timestamp;
	private String text;
	private String code;
	private String status;
	
	public Payload() {
		
	}
	public Payload(String timestamp, String text, String code, String status) 
	{
		super();
	
	this.timestamp=timestamp;
	this.text=text;
	this.code=code;
	this.status=status;
	}
	
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	}

