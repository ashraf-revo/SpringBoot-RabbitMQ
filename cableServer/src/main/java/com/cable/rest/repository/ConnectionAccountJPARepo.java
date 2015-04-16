package com.cable.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cable.rest.entity.ConnectionAccount;


public interface ConnectionAccountJPARepo extends JpaRepository<ConnectionAccount , Long>{

}
