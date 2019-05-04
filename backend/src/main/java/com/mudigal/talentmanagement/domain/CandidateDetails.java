package com.mudigal.talentmanagement.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/***********************************
*
* @author Vijayendra Mudigal
* @contact vijayendrap@gmail.com
*
**********************************/

@Data
@Entity
@Table(name="onboarding_candidate_details")
public class CandidateDetails {
	
	@Id
	@Column(name="email",nullable=false)
	private String email;

	@Column(name="firstname",nullable=false)
	private String firstname;
	
	@Column(name="surname",nullable=false)
	private String surname;
	
	@Column(name="startdate",nullable=false)
	private String startdate;
	
	@Column(name="noticeperiod",nullable=false)
	private String noticeperiod;
	
	@Column(name="address",nullable=false)
	private String address;
	
	@Column(name="contactnumber",nullable=false)
	private String contactnumber;
	
	@Column(name="laptoppreference",nullable=false)
	private String laptoppreference;
	
	@Column(name="status",nullable=false)
	private String status = "NEW";

}
