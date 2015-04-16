package com.cable.rest.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="customer")
public class Customer extends Audit implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter	@Setter	
	private Long customerId;
	
	@Column(nullable=false)
	@Getter	@Setter	
	private String firstName;
	
	@Column(nullable=false)
	@Getter	@Setter	
	private String lastName;
	
	@Column(unique=true,nullable=false)
	@Getter	@Setter	
	private String emailId;
	
	@Column(nullable=false)
	@Getter	@Setter	
	private String password;
	
	@Temporal( TemporalType.DATE)
	@Column(nullable=false)
	@Getter	@Setter	
	private Date dob;
	
	@Column(nullable=false)
	@Getter	@Setter	
	private int sex;
	
	@Column(nullable=false)
	@Getter	@Setter	
	private String mobile;
	
	@Column(nullable=false)
	@Getter	@Setter	
	private Boolean active=false;

	@Column(name="time_stamp", nullable=true,columnDefinition="timestamp default current_timestamp on update current_timestamp")
	@Getter	@Setter	
	private Date timeStamp ;
	
	
	
	
	

}
