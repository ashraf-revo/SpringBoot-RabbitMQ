package com.cable.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cable.rest.model.Area;



public interface AreaJPARepo extends JpaRepository<Area , Long>{
	
}
