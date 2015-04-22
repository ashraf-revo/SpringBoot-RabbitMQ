package com.cable.rest.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.cable.rest.dto.AreaDto;
import com.cable.rest.dto.BaseDto;
import com.cable.rest.dto.CustomerDto;
import com.cable.rest.dto.MasterListDto;
import com.cable.rest.dto.RoleDto;
import com.cable.rest.dto.UserDto;
import com.cable.rest.dto.UserListDto;
import com.cable.rest.exception.AppException;
import com.cable.rest.exception.IErrorImpl;
import com.cable.rest.model.Area;
import com.cable.rest.model.Role;
import com.cable.rest.repository.RoleJPARepo;
import com.cable.rest.search.UserSearch;
import com.cable.rest.utils.ModelEntityMapper;



@Service
public class LoginService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	RoleJPARepo roleRepo;
	
	
	
	public UserDto loginUser(){
		return null;
	}
	
	
	public CustomerDto loginCustomer(){
		return null;
	}
	
	
	@Transactional
	public RoleDto saveRole(RoleDto Object){
		try{
			Role roleEntity=(Role) ModelEntityMapper.converModelToEntity(Object, Role.class);
			roleEntity=roleRepo.save(roleEntity);	
			Object.setRoleId(roleEntity.getRoleId());
			return Object;
		}
		catch(Exception e){
			throw new AppException(IErrorImpl.UNKNOWN_ERROR);
		}
		
	}
	
	@Transactional
	@Rollback(false)
	public UserListDto getRole(UserSearch search){
		try{
			UserListDto result=new UserListDto();
			List<RoleDto> roleList=new ArrayList<RoleDto>();
			Session session = entityManager.unwrap(Session.class);
			
			Criteria criteria= session.createCriteria(Role.class);
			
			if(search.getRoleId() !=null && search.getRoleId() >0l){
				criteria.add(Restrictions.eq("roleId", search.getRoleId()));
			}
			
			List<Role> list=criteria.list();
			
			for( Role entityObject: list){
				RoleDto roleDto=(RoleDto) ModelEntityMapper.converEntityToModel(entityObject, RoleDto.class);
				roleList.add(roleDto);
			}
			result.setRoleDetail(roleList);
			
			return result;
		}
		catch(Exception e){
			return null;
		}
	}
	
	@Transactional
	public BaseDto deleteRole(UserSearch search) {
		try{
			BaseDto result=new BaseDto();
			roleRepo.delete(search.getRoleId());
			return result;
		}
		catch(Exception e){
			return null;
		}
	
	}

}
