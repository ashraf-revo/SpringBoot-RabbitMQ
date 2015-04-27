package com.cable.rest.controller;

import lombok.extern.log4j.Log4j;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cable.rest.dto.BaseDto;
import com.cable.rest.dto.UserDto;
import com.cable.rest.dto.UserListDto;
import com.cable.rest.search.UserSearch;

@RestController
@RequestMapping("/user")
@Log4j
public class UserController extends BaseController {
	
	@RequestMapping(value="/userexit",method=RequestMethod.POST)
	public UserDto  exitUser(@RequestBody UserDto reqObject){
		return (UserDto) sendtoMQ(reqObject, "exitUser", "userService");
	}
	
	@RequestMapping(value="/saveuser",method=RequestMethod.POST)
	public UserDto  saveUser(@RequestBody UserDto reqObject){
		return (UserDto) sendtoMQ(reqObject, "saveUser", "userService");
	}
	
	
	@RequestMapping(value="/userlist",method=RequestMethod.POST)
	public UserListDto getUser(@RequestBody UserSearch searchObject){
		return (UserListDto) sendtoMQ(searchObject, "getUser", "userService");
	}
	
	@RequestMapping(value="/deleteuser",method=RequestMethod.POST)
	public BaseDto deleteUser(@RequestBody UserSearch searchObject){
		return (BaseDto) sendtoMQ(searchObject, "deleteUser", "userService");
	}
	

}
