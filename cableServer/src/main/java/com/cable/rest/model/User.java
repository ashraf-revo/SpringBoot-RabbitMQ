package com.cable.rest.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="user")
public class User extends Audit implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable=false)
	@Getter	@Setter	
	private Long userId;
	
	@Column(nullable=false)
	@Getter	@Setter	
	private String firstName;
	
	@Column(nullable=false)
	@Getter	@Setter	
	private String lastName;
	
	@Column(unique=true,nullable=false)
	@Getter	@Setter	
	private String userName;
	
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
	private String emai_id;
	
	@Column(nullable=false)
	@Getter	@Setter	
	private Boolean active=false;
	
	@OneToMany(mappedBy="user")
	@Getter	@Setter	
	private List<UserRole> userRoles;
	
	

}
