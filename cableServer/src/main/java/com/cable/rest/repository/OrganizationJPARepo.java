package com.cable.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cable.rest.entity.Organization;



public interface OrganizationJPARepo extends JpaRepository< Organization, Long>{

}
