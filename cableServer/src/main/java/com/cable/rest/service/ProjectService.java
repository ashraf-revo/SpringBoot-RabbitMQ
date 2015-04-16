package com.cable.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.cable.rest.dto.OrganizationDto;
import com.cable.rest.entity.Organization;
import com.cable.rest.repository.OrganizationJPARepo;
import com.cable.rest.utils.ModelEntityMapper;

public class ProjectService {
	
	@Autowired
	OrganizationJPARepo orgJPARepo;
	
	@Transactional
	public OrganizationDto createOrganization(OrganizationDto reqObject){
		try{
			Organization orgEntity=(Organization) ModelEntityMapper.converModelToEntity(reqObject, Organization.class);
			
			orgJPARepo.saveAndFlush(orgEntity);
			
			reqObject.setOrgId(orgEntity.getOrgId());
			
		}
		catch(Exception e){
			
		}
		
		return reqObject;
		
	}

}
