package com.cable.rest.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="customer_account")
public class CustomerAccount extends Audit implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable=false)
	@Getter	@Setter	
	private Long customerAccId;
	
	@ManyToOne
	@JoinColumn(name="customer_Id", nullable=false)
	@Getter	@Setter	
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="account_Id", nullable=false)
	@Getter	@Setter	
	private ConnectionAccount connectionAccount;
	
	@Column(nullable=false)
	@Getter	@Setter	
	private Boolean smsNotification=false;
	
	@Column(nullable=false)
	@Getter	@Setter	
	private Boolean emailNotification=false;
	
	@Column(nullable=false)
	@Getter	@Setter	
	private Boolean active;
	
	
}
