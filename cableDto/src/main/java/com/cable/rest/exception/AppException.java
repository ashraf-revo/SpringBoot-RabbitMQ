package com.cable.rest.exception;

import java.util.ArrayList;
import java.util.List;

public class AppException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private List<IError> errors= new ArrayList<IError>();
	
	public AppException(final IError error) {
		  super("Error " + error.getCode() + ((error.getSystemMessage() != null) ? ": " + error.getSystemMessage() : ""));
		  errors.add(error);
	  }

}
