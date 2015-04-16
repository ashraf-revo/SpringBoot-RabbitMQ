package com.cable.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cable.rest.entity.Project;



public interface ProjectJPARepo extends JpaRepository< Project, Long>{

}
