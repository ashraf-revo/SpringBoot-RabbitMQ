package com.cable.rest.model;

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
@Table(name="role")
public class Role extends Audit implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	@Getter	@Setter	
	protected Long roleId;

	@Column(nullable=false, length=250)
	@Getter	@Setter	
	protected String roleName;
	
	@Column(nullable=false)
	@Getter	@Setter	
	protected Boolean roleActive = false;
	
	
	
}
