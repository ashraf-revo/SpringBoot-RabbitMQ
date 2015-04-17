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
@Table(name="zip_code")
public class ZipCode extends Audit implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter	@Setter	
	private Long zipCode;
	
	@Column(nullable=false)
	@Getter	@Setter	
	private String locationName;
	
	@Column(nullable=false)
	@Getter	@Setter	
	private String pinCcode;
	
	@Column(nullable=false)
	@Getter	@Setter	
	private String district;
	
	@Column(nullable=false)
	@Getter	@Setter	
	private String state;
	
	@Column(nullable=false)
	@Getter	@Setter	
	private String country;
	
	@Column(nullable=false)
	@Getter	@Setter	
	private Boolean active=false;

	
	
	

}
