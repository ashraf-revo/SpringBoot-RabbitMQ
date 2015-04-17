package com.cable.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cable.rest.model.CustomerAccount;

public interface CustomerAccountJPARepo extends JpaRepository<CustomerAccount , Long>{

}
