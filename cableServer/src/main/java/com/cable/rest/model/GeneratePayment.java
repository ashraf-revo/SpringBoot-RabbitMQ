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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="generate_payment")
public class GeneratePayment extends Audit implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter	@Setter	
	private Long paymentId;
	
	@Column(nullable=false)
	@Getter	@Setter	
	private int paymentType;
	
	@Column(nullable=false)
	@Getter	@Setter	
	private int paymentStatus;
	
	@Temporal( TemporalType.DATE)
	@Column(nullable=false)
	@Getter	@Setter	
	private Date paymentDate;
	
	@Column(nullable=false)
	@Getter	@Setter	
	private Long paymentUser;
	
	@Column(nullable=false)
	@Getter	@Setter	
	private Long paymentCustomer;
	
	@Temporal( TemporalType.TIMESTAMP)
	@Column(nullable=false)
	@Getter	@Setter	
	private Date dueDate;
	
	@Column(nullable=false)
	@Getter	@Setter	
	private Double paymentAmount;
	
	@ManyToOne
	@JoinColumn(name="account_Id", nullable=false)
	@Getter	@Setter	
	private ConnectionAccount connectionAccount;
	
	
	
	
	

}
