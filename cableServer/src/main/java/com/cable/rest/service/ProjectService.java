package com.cable.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cable.rest.dto.OrganizationDto;
import com.cable.rest.dto.ProjectDto;
import com.cable.rest.model.Organization;
import com.cable.rest.model.Project;
import com.cable.rest.repository.OrganizationJPARepo;
import com.cable.rest.repository.ProjectJPARepo;
import com.cable.rest.search.ProjectSearch;
import com.cable.rest.utils.ModelEntityMapper;


@Service
public class ProjectService {
	
	@Autowired
	OrganizationJPARepo organizationJPARepo;
	
	@Autowired
	ProjectJPARepo projectJPARepo;
	
	
	@Transactional
	public OrganizationDto saveOrganization(OrganizationDto reqObject){
		try{
			Organization orgEntity=(Organization) ModelEntityMapper.converModelToEntity(reqObject, Organization.class);
			
			organizationJPARepo.saveAndFlush(orgEntity);
			
			reqObject.setOrgId(orgEntity.getOrgId());
			
		}
		catch(Exception e){
			
		}
		
		return reqObject;
		
	}
	
	
	public List<OrganizationDto> getOrganization(ProjectSearch search) {
		return null;
	}
	
	public boolean deleteOrganization(ProjectSearch search) {
		return false;
	}
	
	
	@Transactional
	public boolean saveProject(ProjectDto Object) {
		try{
			Project projectEntity=(Project) ModelEntityMapper.converModelToEntity(Object, Project.class);
			projectJPARepo.saveAndFlush(projectEntity);
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	public List<ProjectDto> getProject(ProjectSearch search) {
		return null;
	}

	
	public boolean deleteProject(ProjectSearch search) {
		return false;
	}
	
	
	
}
