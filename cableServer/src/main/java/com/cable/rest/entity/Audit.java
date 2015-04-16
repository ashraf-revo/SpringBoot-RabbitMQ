package com.cable.rest.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
public abstract class Audit implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Temporal( TemporalType.TIMESTAMP)
	@Column(name="created_date", nullable=false)
	@Getter	@Setter	
	private Date createdDate;
	
	@Column(name="created_by", nullable=false)
	@Getter	@Setter	
	private Long createdBy;

	@Temporal( TemporalType.TIMESTAMP)
	@Column(name="last_modified_Date", nullable=true)
	@Getter	@Setter	
	private Date lastModifiedDate;
	
	@Column(name="last_modified_by", nullable=true)
	@Getter	@Setter	
	private Long lastModifiedBy;
	
	@Column(name="time_stamp", nullable=true,columnDefinition="timestamp default current_timestamp on update current_timestamp")
	@Getter	@Setter	
	private Date timeStamp ;


	@PrePersist
	public void prePersist() {
		try {
			/*UserAccountModel userAccountModel = (UserAccountModel) SecurityContextHolder
					.getContext().getAuthentication().getPrincipal();*/

			setCreatedBy(1L);
			setCreatedDate(new Date());
			setLastModifiedBy(0L);
			setLastModifiedDate(null);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	@PreUpdate
	public void preUpdate() {
		try {
			setLastModifiedBy(1L);
			setLastModifiedDate(new Date());
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
