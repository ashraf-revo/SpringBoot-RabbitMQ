package com.cable.rest.controller;

import lombok.extern.log4j.Log4j;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cable.rest.dto.BaseDto;
import com.cable.rest.dto.RoleDto;
import com.cable.rest.dto.UserListDto;
import com.cable.rest.search.UserSearch;

@RestController
@RequestMapping("/login")
@Log4j
public class LoginController extends BaseController {
	
	@RequestMapping(value="/saverole",method=RequestMethod.POST)
	public RoleDto  saveRole(@RequestBody RoleDto reqObject){
		return (RoleDto) sendtoMQ(reqObject, "saveRole", "loginService");
	}
	
	
	@RequestMapping(value="/rolelist",method=RequestMethod.POST)
	public UserListDto getRole(@RequestBody UserSearch searchObject){
		return (UserListDto) sendtoMQ(searchObject, "getRole", "loginService");
	}
	
	@RequestMapping(value="/deleterole",method=RequestMethod.POST)
	public BaseDto deleteRole(@RequestBody UserSearch searchObject){
		return (BaseDto) sendtoMQ(searchObject, "deleteRole", "loginService");
	}
	

}
