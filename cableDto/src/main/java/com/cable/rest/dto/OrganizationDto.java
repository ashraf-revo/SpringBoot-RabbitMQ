package com.cable.rest.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrganizationDto implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	@Getter	@Setter	
	private Long orgId;
	
	@Getter	@Setter	
	private String orgName;
	
	@Getter	@Setter	
	private String orgToken;
	
	@Getter	@Setter	
	private String address1;
	
	@Getter	@Setter	
	private String address2;
	
	@Getter	@Setter	
	private String pinCode;
	
	@Getter	@Setter	
	protected Boolean active = false;
	
	
}
