package com.cable.rest.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StreetDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Getter	@Setter	
	private Long streetId;
	
	@Getter	@Setter	
	private String streetName;
	
	@Getter	@Setter	
	private AreaDto area;
	
	@Getter	@Setter	
	private Boolean active;

}
