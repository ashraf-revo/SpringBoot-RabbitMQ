package com.cable.rest.exception;

import java.util.ResourceBundle;

public enum IErrorImpl implements IError{
	
	SEARCH_ERROR("0001","Unable to Fetch data",Category.SYSTEM,Severity.FATAL),
	
	
	UNKNOWN_ERROR("9999", "Undefined Error Code",Category.SYSTEM,Severity.MAJOR);
	
	
	
	private ResourceBundle bundle=ResourceBundle.getBundle("com.cablecard.app.exception.messages");
	
	private String code;
	private  String systemMessage;
	private String displayMessage;
	private Category category;
	private Severity severity;
	
	
	private IErrorImpl(String code, String systemMessage,Category category,Severity severity) {
		  this.code = code;
		  this.systemMessage = systemMessage;
		  this.category=category;
		  this.severity=severity;
		  this.displayMessage=bundle.getString(getClass().getSimpleName()+"."+toString());
	}
	
	@Override
	public String getCode() {
		return code;
	}

	@Override
	public String getSystemMessage() {
		return systemMessage;	
	}

	@Override
	public String getDisplayMessage() {
		return displayMessage;
	}

	@Override
	public Category getCategory() {
		return category;
	}

	
	@Override
	public Severity getSeverity() {
		return severity;
	}
	
	
	
	
	
	
	
	
	

}
