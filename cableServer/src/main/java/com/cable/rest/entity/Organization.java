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
@Table(name="organization")
public class Organization extends Audit implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter	@Setter	
	private Long orgId;
	
	@Column(nullable=false)
	@Getter	@Setter	
	private String orgName;
	
	@Column(unique=true,nullable=false)
	@Getter	@Setter	
	private String orgToken;
	
	@Column(nullable=false)
	@Getter	@Setter	
	private String address1;
	
	@Column(nullable=false)
	@Getter	@Setter	
	private String address2;

	@Column(nullable=false)
	@Getter	@Setter	
	private String pinCode;
	
	@Column(nullable=false)
	@Getter	@Setter	
	protected Boolean active = false;
	
	@Column(name="time_stamp", nullable=true,columnDefinition="timestamp default current_timestamp on update current_timestamp")
	@Getter	@Setter	
	private Date timeStamp ;

}
