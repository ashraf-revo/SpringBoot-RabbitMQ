package com.cable.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


import com.cable.rest.model.Project;



public interface ProjectJPARepo extends JpaRepository< Project, Long>{

}
