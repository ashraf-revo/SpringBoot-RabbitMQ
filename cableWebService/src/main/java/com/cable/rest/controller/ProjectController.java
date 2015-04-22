package com.cable.rest.controller;

import lombok.extern.log4j.Log4j;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cable.rest.dto.BaseDto;
import com.cable.rest.dto.OrganizationDto;
import com.cable.rest.dto.ProjectDto;
import com.cable.rest.dto.ProjectListDto;
import com.cable.rest.search.ProjectSearch;

@RestController
@RequestMapping("/project")
@Log4j
public class ProjectController extends BaseController {
	
	
	
	@RequestMapping(value="/saveorganization",method=RequestMethod.POST)
	public OrganizationDto  saveOrganization(@RequestBody OrganizationDto reqObject){
		return (OrganizationDto) sendtoMQ(reqObject, "saveOrganization", "projectService");
	}
	
	@RequestMapping(value="/organizationlist",method=RequestMethod.POST)
	public ProjectListDto getOrganization(@RequestBody ProjectSearch searchObject){
		return (ProjectListDto) sendtoMQ(searchObject, "getOrganization", "projectService");
	}
	
	@RequestMapping(value="/deleteorganization",method=RequestMethod.POST)
	public BaseDto deleteOrganization(@RequestBody ProjectSearch searchObject){
		return (BaseDto) sendtoMQ(searchObject, "deleteOrganization", "projectService");
	}
	
	@RequestMapping(value="/saveproject",method=RequestMethod.POST)
	public ProjectDto  saveProject(@RequestBody ProjectDto reqObject){
		return (ProjectDto) sendtoMQ(reqObject, "saveProject", "projectService");
	}
	
	@RequestMapping(value="/projectlist",method=RequestMethod.POST)
	public ProjectListDto getProject(@RequestBody ProjectSearch searchObject){
		return (ProjectListDto) sendtoMQ(searchObject, "getProject", "projectService");
	}
	
	@RequestMapping(value="/deleteproject",method=RequestMethod.POST)
	public BaseDto deleteProject(@RequestBody ProjectSearch searchObject){
		return (BaseDto) sendtoMQ(searchObject, "deleteProject", "projectService");
	}
	
}
