package com.cable.rest.entity;

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
@Table(name="Connection_account")
public class ConnectionAccount extends Audit implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable=false)
	@Getter	@Setter	
	private Long accountId;
	
	@Column(nullable=false)
	@Getter	@Setter	
	private String accountToken;
	
	@Column(nullable=false)
	@Getter	@Setter	
	private String address;
	
	@ManyToOne
	@JoinColumn(name="street_Id", nullable=false)
	@Getter	@Setter	
	private Street street;
	
	@ManyToOne
	@JoinColumn(name="project_Id", nullable=false)
	@Getter	@Setter	
	private Project project;
	
	@Column(nullable=false)
	@Getter	@Setter	
	private Long rentAmount;
	
	@Column(nullable=false)
	@Getter	@Setter	
	private Boolean active;
	
	@Column(name="time_stamp", nullable=true,columnDefinition="timestamp default current_timestamp on update current_timestamp")
	@Getter	@Setter	
	private Date timeStamp ;
	
	

}
