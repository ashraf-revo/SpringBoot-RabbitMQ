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
@Table(name="street")
public class Street extends Audit implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter	@Setter	
	private Long streetId;
	
	@Column(nullable=false)
	@Getter	@Setter	
	private String streetName;
	
	@ManyToOne
	@JoinColumn(name="area_Id", nullable=false)
	@Getter	@Setter	
	private Area area;
	
	@Column(nullable=false)
	@Getter	@Setter	
	private Boolean active;
	
	@Column(name="time_stamp", nullable=true,columnDefinition="timestamp default current_timestamp on update current_timestamp")
	@Getter	@Setter	
	private Date timeStamp ;
	
	

	
	
}
