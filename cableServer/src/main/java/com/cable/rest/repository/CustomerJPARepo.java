package com.cable.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cable.rest.entity.Customer;



public interface CustomerJPARepo extends JpaRepository< Customer, Long>{

}
