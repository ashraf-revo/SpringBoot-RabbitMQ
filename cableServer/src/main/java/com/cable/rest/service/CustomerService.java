package com.cable.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.cable.rest.dto.CustomerDto;
import com.cable.rest.model.Customer;
import com.cable.rest.repository.CustomerJPARepo;
import com.cable.rest.search.UserSearch;
import com.cable.rest.utils.ModelEntityMapper;



public class CustomerService {

	@Autowired
	CustomerJPARepo customerRepo;
	
	public boolean exitCustomer(){
		return false;
	}
	
	@Transactional
	public boolean saveCustomer(CustomerDto customerObject) {
		try{
			Customer customerEntity=(Customer) ModelEntityMapper.converObjectToPoJo(customerObject, Customer.class);
			customerRepo.save(customerEntity);
		}
		catch(Exception e){
			//throw new AppException(IErrorImpl.UNKNOWN_ERROR);
		}
		return true;
	
	}
	
	public List<CustomerDto> getCustomer(UserSearch search) {
		return null;
	}
	
	public boolean deleteCustomer() {
		return false;
	}
}
