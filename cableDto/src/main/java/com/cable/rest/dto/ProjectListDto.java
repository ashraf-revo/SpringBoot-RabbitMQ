package com.cable.rest.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectListDto implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	private List<ProjectDto> projectList;
	
	@Getter	@Setter	
	private List<OrganizationDto> orgDetails;

}
