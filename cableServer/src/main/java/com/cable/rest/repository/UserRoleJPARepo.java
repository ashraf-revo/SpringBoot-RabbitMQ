package com.cable.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cable.rest.entity.UserRole;



public interface UserRoleJPARepo extends JpaRepository< UserRole, Long>{

}
