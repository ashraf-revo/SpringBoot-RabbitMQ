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
@Table(name="project")
public class Project extends Audit implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter	@Setter	
	private Long projectId;
	
	@Column(nullable=false)
	@Getter	@Setter	
	private String projectName;
	
	@ManyToOne
	@JoinColumn(name="org_Id", nullable=false)
	@Getter	@Setter	
	private Organization organization;
	
	@Column(nullable=false)
	@Getter	@Setter	
	private String address1;
	
	@Column(nullable=false)
	@Getter	@Setter	
	private String address2;

	@ManyToOne
	@JoinColumn(name="zip_Code", nullable=false)
	@Getter	@Setter	
	private ZipCode zipCode;
	
	@Column(nullable=false)
	@Getter	@Setter	
	protected Boolean active = false;
	
	@Column(nullable=false)
	@Getter	@Setter	
	private String email;
	
	@Column(nullable=false)
	@Getter	@Setter	
	private String mobile;
	
	@Column(nullable=false)
	@Getter	@Setter	
	private Double advanceAmount;
	
	@Column(nullable=false)
	@Getter	@Setter	
	protected Boolean onlinePaymentFlag = false;
	
	@Column(nullable=false)
	@Getter	@Setter	
	private int paymentGenerateDate;
	
	@Column(nullable=false)
	@Getter	@Setter	
	private int paymentDueDate;
	
	@Column(name="time_stamp", nullable=true,columnDefinition="timestamp default current_timestamp on update current_timestamp")
	@Getter	@Setter	
	private Date timeStamp ;
	
	
	
	
	

}
