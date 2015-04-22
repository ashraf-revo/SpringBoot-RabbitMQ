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
import com.cable.rest.dto.MasterListDto;
import com.cable.rest.dto.UserDto;
import com.cable.rest.dto.UserListDto;
import com.cable.rest.dto.UserRoleDto;
import com.cable.rest.model.Area;
import com.cable.rest.model.User;
import com.cable.rest.model.UserRole;
import com.cable.rest.repository.UserJPARepo;
import com.cable.rest.repository.UserRoleJPARepo;
import com.cable.rest.search.MasterSearch;
import com.cable.rest.search.UserSearch;
import com.cable.rest.utils.ModelEntityMapper;



@Service
public class UserService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	UserJPARepo userRepo;
	
	@Autowired
	UserRoleJPARepo userRoleRepo;
	
	public boolean exitUser(){
		return false;
		
	}
	
	
	
	@Transactional
	public UserDto saveUser(UserDto userObject){
		try{
			User userEntity=(User) ModelEntityMapper.converModelToEntity(userObject, User.class);
			userEntity=userRepo.save(userEntity);
			
			if(userEntity.getUserId()==null){
				return userObject;
			}
			
			userObject.setUserId(userEntity.getUserId());
			
			for(UserRoleDto roleUser : userObject.getUserRoles()){
				roleUser.setUser(userObject);
				UserRole userRoleEntity=(UserRole) ModelEntityMapper.converModelToEntity(roleUser, UserRole.class);
				
				userRoleRepo.save(userRoleEntity);
			}
			return userObject;
			
		}
		catch(Exception e){
			return null;
			//throw new AppException(IErrorImpl.UNKNOWN_ERROR);
		}
		
	}
	
	
	@Transactional
	@Rollback(false)
	public UserListDto getUser(UserSearch search){
		try{
			UserListDto result=new UserListDto();
			List<UserDto> userList=new ArrayList<UserDto>();
			Session session = entityManager.unwrap(Session.class);
			
			Criteria criteria= session.createCriteria(User.class);
			
			if(search.getUserId()!=null && search.getUserId() >0l){
				criteria.add(Restrictions.eq("userId", search.getUserId()));
			}
			
			List<User> list=criteria.list();
			
			for( User entityObject: list){
				UserDto userDto=(UserDto) ModelEntityMapper.converEntityToModel(entityObject, UserDto.class);
				userList.add(userDto);
			}
			result.setUserlist(userList);
			
			return result;
		}
		catch(Exception e){
			return null;
		}
	}
	
	@Transactional
	public BaseDto deleteUser(UserSearch search) {
		try{
			BaseDto result=new BaseDto();
			userRepo.delete(search.getUserId());
			return result;
		}
		catch(Exception e){
			return null;
		}
	}
	

}
