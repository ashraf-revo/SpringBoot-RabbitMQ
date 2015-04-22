package com.cable.rest.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectDto implements Serializable  {
	
	private static final long serialVersionUID = 1L;

	@Getter @Setter
	private Long projectId;
	@Getter @Setter
	private String projectName;
	@Getter @Setter
	private OrganizationDto organization;
	@Getter @Setter
	private String address1;
	@Getter @Setter
	private String address2;
	@Getter @Setter
	private ZipCodeDto zipCode;
	@Getter @Setter
	protected Boolean active = false;
	@Getter @Setter
	private String email;
	@Getter @Setter
	private String mobile;
	@Getter @Setter
	private Double advanceAmount;
	@Getter @Setter
	private Boolean onlinePaymentFlag = false;
	@Getter @Setter
	private int paymentGenerateDate;
	@Getter @Setter
	private int paymentDueDate;

}
