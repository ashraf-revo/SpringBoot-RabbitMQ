package com.cable.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cable.rest.model.CustomerPasswordToken;

public interface CustomerPasswordTokenJPARepo extends JpaRepository<CustomerPasswordToken , Long>{

}
