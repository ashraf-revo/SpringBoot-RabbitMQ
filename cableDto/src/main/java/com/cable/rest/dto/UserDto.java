package com.cable.rest.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;


@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto  implements Serializable  {
	
	private static final long serialVersionUID = 1L;

	
	@Getter	@Setter	
	private Long userId;
	
	@Getter	@Setter	
	private String firstName;
	
	@Getter	@Setter	
	private String lastName;
	
	@Getter	@Setter	
	private String userName;
	
	@Getter	@Setter	
	private String password;
	
	@Getter	@Setter	
	private Date dob;
	
	@Getter	@Setter	
	private int sex;
	
	@Getter	@Setter	
	private String mobile;
	
	@Getter	@Setter	
	private String emai_id;
	
	@Getter	@Setter	
	private Boolean active=false;
	
	@Getter	@Setter	
	private List<UserRoleDto> userRoles;
	
}
