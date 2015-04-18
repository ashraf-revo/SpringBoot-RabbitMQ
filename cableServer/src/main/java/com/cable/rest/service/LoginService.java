package com.cable.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cable.rest.dto.CustomerDto;
import com.cable.rest.dto.RoleDto;
import com.cable.rest.dto.UserDto;
import com.cable.rest.model.Role;
import com.cable.rest.repository.RoleJPARepo;
import com.cable.rest.utils.ModelEntityMapper;



@Service
public class LoginService {
	
	@Autowired
	RoleJPARepo roleRepo;
	
	
	
	public UserDto loginUser(){
		return null;
	}
	
	
	public CustomerDto loginCustomer(){
		return null;
	}
	
	
	@Transactional
	public boolean saveRole(RoleDto Object){
		try{
			Role roleEntity=(Role) ModelEntityMapper.converModelToEntity(Object, Role.class);
			roleEntity=roleRepo.save(roleEntity);	
		}
		catch(Exception e){
			//throw new AppException(IErrorImpl.UNKNOWN_ERROR);
		}
		return true;
	}
	
	
	public List<RoleDto> getRole(){
		return null;
	}
	
	public boolean deleteRole() {
		return false;
	}

}
