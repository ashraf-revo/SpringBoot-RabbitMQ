package com.cable.rest.exception;

public interface IError {

	public String getCode();

	public String getSystemMessage();
	
	public String getDisplayMessage();
	
	public Category getCategory();
	
	public Severity getSeverity();
}
