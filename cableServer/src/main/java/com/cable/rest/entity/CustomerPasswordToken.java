package com.cable.rest.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Customer_password_token")
public class CustomerPasswordToken extends Audit implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable=false)
	@Getter	@Setter
	private Long passwordToken;
	
	@Column(nullable=false)
	@Getter	@Setter
	private Long customerId;
	
	@Column(nullable=false)
	@Getter	@Setter
	private Date tokenUsedDate;
	
	@Column(nullable=false)
	@Getter	@Setter
	private Boolean tokenUsedFlag=false;
	
	@Column(name="time_stamp", nullable=true,columnDefinition="timestamp default current_timestamp on update current_timestamp")
	@Getter	@Setter	
	private Date timeStamp ;

}
