package com.cable.rest.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

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
	
	@Column(name="time_stamp", nullable=true,columnDefinition="timestamp default current_timestamp on update current_timestamp")
	@Getter	@Setter	
	private Date timeStamp ;
}
