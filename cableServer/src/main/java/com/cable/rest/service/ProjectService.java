package com.cable.rest.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.cable.rest.dto.BaseDto;
import com.cable.rest.dto.OrganizationDto;
import com.cable.rest.dto.ProjectDto;
import com.cable.rest.dto.ProjectListDto;
import com.cable.rest.model.Organization;
import com.cable.rest.model.Project;
import com.cable.rest.repository.OrganizationJPARepo;
import com.cable.rest.repository.ProjectJPARepo;
import com.cable.rest.search.ProjectSearch;
import com.cable.rest.utils.ModelEntityMapper;


@Service
public class ProjectService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	OrganizationJPARepo organizationJPARepo;
	
	@Autowired
	ProjectJPARepo projectJPARepo;
	
	
	@Transactional
	public OrganizationDto saveOrganization(OrganizationDto reqObject){
		try{
			Organization orgEntity=(Organization) ModelEntityMapper.converObjectToPoJo(reqObject, Organization.class);
			
			organizationJPARepo.saveAndFlush(orgEntity);
			
			reqObject.setOrgId(orgEntity.getOrgId());
			
		}
		catch(Exception e){
			
		}
		
		return reqObject;
		
	}
	
	@Transactional
	@Rollback(false)
	public ProjectListDto getOrganization(ProjectSearch search) {
		try{
			ProjectListDto result=new ProjectListDto();
			List<OrganizationDto> orgDetails=new ArrayList<OrganizationDto>();
			Session session = entityManager.unwrap(Session.class);
			
			Criteria criteria= session.createCriteria(Organization.class);
			
			if(search.getOrgId() !=null && search.getOrgId() >0l){
				criteria.add(Restrictions.eq("orgId", search.getOrgId()));
			}
			
			if(!StringUtils.isEmpty(search.getOrgName())){
				criteria.add(Restrictions.eq("orgName", search.getOrgName()));
			}
			
			if(!StringUtils.isEmpty(search.getPinCode())){
				criteria.add(Restrictions.eq("pinCode", search.getPinCode()));
			}
			List<Organization> list=criteria.list();
			//List<OrganizationDto> list=criteria.setResultTransformer(Transformers.aliasToBean(OrganizationDto.class)).list();
			
			for( Organization orgObject: list){
				OrganizationDto orgDto=(OrganizationDto) ModelEntityMapper.converObjectToPoJo(orgObject, OrganizationDto.class);
				orgDetails.add(orgDto);
			}
			
			result.setOrgDetails(orgDetails);
			return result;
			
		}
		catch(Exception e){
			return null;
		}
		
	}
	
	@Transactional
	public BaseDto deleteOrganization(ProjectSearch search) {
		try{
			BaseDto result=new BaseDto();
			organizationJPARepo.delete(search.getOrgId());
			return result;
		}
		catch(Exception e){
			return null;
		}
		
	}
	
	
	@Transactional
	public ProjectDto saveProject(ProjectDto Object) {
		try{
			Project projectEntity=(Project) ModelEntityMapper.converObjectToPoJo(Object, Project.class);
			projectJPARepo.saveAndFlush(projectEntity);
			Object.setProjectId(projectEntity.getProjectId());
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return Object;
	}

	@Transactional
	@Rollback(false)
	public ProjectListDto getProject(ProjectSearch search) {
		try{
			ProjectListDto result=new ProjectListDto();
			List<ProjectDto> projectDetails=new ArrayList<ProjectDto>();
			Session session = entityManager.unwrap(Session.class);
			
			Criteria criteria= session.createCriteria(Project.class);
			
			if(search.getProjectId() !=null && search.getProjectId() >0l){
				criteria.add(Restrictions.eq("projectId", search.getProjectId()));
			}
			
			if(!org.apache.commons.lang.StringUtils.isEmpty(search.getProjectName())){
				criteria.add(Restrictions.eq("projectName", search.getProjectName()));
			}
			
			List<Project> list=criteria.list();
			
			for( Project projectObject : list){
				ProjectDto projectDto=(ProjectDto) ModelEntityMapper.converObjectToPoJo(projectObject, ProjectDto.class);
				projectDetails.add(projectDto);
			}
			
			result.setProjectList(projectDetails);
			
			
			return result;
		}
		catch(Exception e){
			return null;
		}
		
	}

	@Transactional
	public BaseDto deleteProject(ProjectSearch search) {
		try{
			BaseDto result=new BaseDto();
			projectJPARepo.delete(search.getProjectId());
			return result;
		}
		catch(Exception e){
			return null;
		}
		
	}
	
	
	
}
