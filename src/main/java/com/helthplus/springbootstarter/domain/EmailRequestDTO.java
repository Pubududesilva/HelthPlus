package com.helthplus.springbootstarter.domain;

public class EmailRequestDTO {

private String to;
	
	private String subject;
	
	private String body;
	
	private int statusCode;
	
	private String status;
	
	private DoctorEmailDTO userEmailDTO;
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public EmailRequestDTO(){
		
	}
	
	public EmailRequestDTO(String to, String subject, String body) {
		super();
		this.to = to;
		this.subject = subject;
		this.body = body;
	}
	
	public DoctorEmailDTO getUserEmailDTO() {
		return userEmailDTO;
	}
	public void setUserEmailDTO(DoctorEmailDTO userEmailDTO) {
		this.userEmailDTO = userEmailDTO;
	}

}