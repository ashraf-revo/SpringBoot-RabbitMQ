package com.cable.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cable.rest.entity.GeneratePayment;

public interface GeneratePaymentJPARepo extends JpaRepository<GeneratePayment , Long>{

}
