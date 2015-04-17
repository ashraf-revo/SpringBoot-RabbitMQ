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
@Table(name="area")
public class Area extends Audit implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter	@Setter	
	private Long areaId;
	
	@Column(nullable=false)
	@Getter	@Setter	
	private String areaName;
	
	@ManyToOne
	@JoinColumn(name="zip_Code", nullable=false)
	@Getter	@Setter	
	private ZipCode zipCode;
	
	@ManyToOne
	@JoinColumn(name="project_Id", nullable=false)
	@Getter	@Setter	
	private Project project;
	
	@Column(nullable=false)
	@Getter	@Setter	
	private Boolean active=false;
	
	

	
	
	
	
	

}
