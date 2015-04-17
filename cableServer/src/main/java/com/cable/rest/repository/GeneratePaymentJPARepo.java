package com.cable.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cable.rest.model.GeneratePayment;

public interface GeneratePaymentJPARepo extends JpaRepository<GeneratePayment , Long>{

}
