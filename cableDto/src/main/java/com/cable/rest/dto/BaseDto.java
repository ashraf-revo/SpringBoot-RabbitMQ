package com.cable.rest.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseDto implements Serializable  {
	
	private static final long serialVersionUID = 1L;

}
