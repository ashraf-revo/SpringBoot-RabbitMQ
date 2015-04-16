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
@Table(name="user_role")
public class UserRole extends Audit implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter	@Setter	
	private Long userRoleId;
	
	@ManyToOne
	@JoinColumn(name="user_Id", nullable=false)
	@Getter	@Setter	
	private User user;
	
	@ManyToOne
	@JoinColumn(name="role_Id", nullable=false)
	@Getter	@Setter	
	private Role role;
	
	@ManyToOne
	@JoinColumn(name="project_Id", nullable=false)
	@Getter	@Setter	
	private Project project;
	
	@Column(nullable=false)
	@Getter	@Setter	
	private Boolean active=false;
	
	@Column(name="time_stamp", nullable=true,columnDefinition="timestamp default current_timestamp on update current_timestamp")
	@Getter	@Setter	
	private Date timeStamp ;
	
	

}
