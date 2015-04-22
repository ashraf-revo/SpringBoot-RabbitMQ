package com.cable.rest.dto;


import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
@JsonIgnoreProperties(ignoreUnknown = true)
public class AreaDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Getter	@Setter	
	private Long areaId;
	
	@Getter	@Setter	
	private String areaName;
	
	@Getter	@Setter	
	private ZipCodeDto zipCode;
	
	@Getter	@Setter	
	private ProjectDto project;
	
	@Getter	@Setter	
	private Boolean active=false;

}
