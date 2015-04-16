package com.cable.rest.controller;

import lombok.extern.log4j.Log4j;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cable.rest.dto.OrganizationDto;

@RestController
@RequestMapping("/project")
@Log4j
public class ProjectController extends BaseController {
	
	@RequestMapping(value="/createOrganization",method=RequestMethod.POST)
	public OrganizationDto  createOrganization(@RequestBody OrganizationDto reqObject){
		log.info("Ticket Creation Controler");
		return (OrganizationDto) sendtoMQ(reqObject, "createOrganization", "projectService");
	}
	
}
