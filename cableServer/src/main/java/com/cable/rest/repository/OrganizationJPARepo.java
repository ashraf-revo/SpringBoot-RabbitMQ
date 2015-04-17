package com.cable.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


import com.cable.rest.model.Organization;



public interface OrganizationJPARepo extends JpaRepository< Organization, Long>{

}
