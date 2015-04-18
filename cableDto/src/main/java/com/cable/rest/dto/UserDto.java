package com.cable.rest.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;



public class UserDto {

	@Getter @Setter
	private List<UserRoleDto> userRoles;
	
	
}
