package com.cable.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cable.rest.model.User;




public interface UserJPARepo extends JpaRepository< User, Long>{

}
