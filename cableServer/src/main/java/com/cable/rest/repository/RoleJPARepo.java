package com.cable.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cable.rest.entity.Role;



public interface RoleJPARepo extends JpaRepository< Role, Long>{

}
