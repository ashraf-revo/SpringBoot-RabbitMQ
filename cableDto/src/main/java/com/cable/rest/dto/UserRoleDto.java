package com.cable.rest.dto;



import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRoleDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Getter	@Setter	
	private Long userRoleId;
	
	@Getter	@Setter	
	private UserDto user;
	
	@Getter	@Setter	
	private RoleDto role;
	
	@Getter	@Setter	
	private ProjectDto project;
	
	@Getter	@Setter	
	private Boolean active=false;
}
