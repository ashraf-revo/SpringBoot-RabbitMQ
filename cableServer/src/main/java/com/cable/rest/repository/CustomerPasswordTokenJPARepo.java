package com.cable.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cable.rest.entity.CustomerPasswordToken;

public interface CustomerPasswordTokenJPARepo extends JpaRepository<CustomerPasswordToken , Long>{

}
