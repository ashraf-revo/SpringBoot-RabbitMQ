package com.cable.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cable.rest.dto.UserDto;
import com.cable.rest.dto.UserRoleDto;
import com.cable.rest.model.User;
import com.cable.rest.model.UserRole;
import com.cable.rest.repository.UserJPARepo;
import com.cable.rest.repository.UserRoleJPARepo;
import com.cable.rest.search.UserSearch;
import com.cable.rest.utils.ModelEntityMapper;



@Service
public class UserService {
	
	
	@Autowired
	UserJPARepo userRepo;
	
	@Autowired
	UserRoleJPARepo userRoleRepo;
	
	public boolean exitUser(){
		return false;
		
	}
	
	
	
	@Transactional
	public boolean saveUser(UserDto userObject){
		try{
			User userEntity=(User) ModelEntityMapper.converModelToEntity(userObject, User.class);
			userEntity=userRepo.save(userEntity);
			if(userEntity.getUserId()==null){
				return false;
			}
			
			for(UserRoleDto roleUser : userObject.getUserRoles()){
				UserRole userRoleEntity=(UserRole) ModelEntityMapper.converModelToEntity(roleUser, UserRole.class);
				
				userRoleRepo.save(userRoleEntity);
			}
			
			
		}
		catch(Exception e){
			//throw new AppException(IErrorImpl.UNKNOWN_ERROR);
		}
		return true;
	}
	
	

	public List<UserDto> getUser(UserSearch search){
		return null;
	}
	
	
	public boolean deleteUser(){
		return false;
	}

}
